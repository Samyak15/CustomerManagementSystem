package com.CustomerManagement.customerManagement.Services;

import com.CustomerManagement.customerManagement.DAO.CustomerRepository;
import com.CustomerManagement.customerManagement.Entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Modifying
    @Transactional
    @Override
    public void updateCustomerDetails(String firstname, String lastname, String stre, String addr, String cty, String st, String mail, String phoneno, Long id) {

        if(firstname==null) firstname = customerRepository.getReferenceById(id).getFirstName();
        if(lastname==null) lastname = customerRepository.getReferenceById(id).getLastName();
        if(stre==null) stre = customerRepository.getReferenceById(id).getStreet();
        if(addr==null) addr = customerRepository.getReferenceById(id).getAddress();
        if(cty==null) cty = customerRepository.getReferenceById(id).getCity();
        if(st==null) st = customerRepository.getReferenceById(id).getState();
        if(mail==null) mail = customerRepository.getReferenceById(id).getEmail();
        if(phoneno==null) phoneno = customerRepository.getReferenceById(id).getPhone();

        customerRepository.updateCustomerDetails(firstname,lastname,stre,addr,cty,st,mail,phoneno,id);
    }

    @Override
    @Transactional
    @Modifying
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public Optional<Customer> getCustomerByid(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAllCustomers(Optional<String> searchtype ,Optional<String> searchval,Optional<Integer> page, Optional<Integer> sz, Optional<String> sortBy) {

        System.out.println(searchtype+": searchtype");
        //System.out.println(searchval.get()+": searchval");
        Page<Customer> customerPage;
        if (!searchtype.isEmpty() && !searchval.isEmpty()) {
            List<Customer> customerList = new ArrayList<>();
            if (searchtype.get().equalsIgnoreCase("firstName")) {
                System.out.println(searchval.get()+": searchval");
                customerList = customerRepository.findByFirstName(searchval.get());
            }
            if (searchtype.get().equalsIgnoreCase("city")) {
                customerList = customerRepository.findByCity(searchval.get());
            }
            if (searchtype.get().equalsIgnoreCase("email")) {
                customerList = customerRepository.findByEmail(searchval.get());
            }
            if (searchtype.get().equalsIgnoreCase("phone")) {
                customerList = customerRepository.findByPhone(searchval.get());
            }


            Pageable pageable = PageRequest.of(page.orElse(0), sz.orElse(2), Sort.Direction.ASC, sortBy.orElse("id"));
            customerPage = convertListToPage(customerList, pageable);
        } else {
            customerPage = customerRepository.findAll(
                    PageRequest.of(page.orElse(0), sz.orElse(5), Sort.Direction.ASC, sortBy.orElse("id"))
            );
        }
        return customerPage;
    }


        public static <T > Page < T > convertListToPage(List < T > list, Pageable pageable) {
            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), list.size());

            return new PageImpl<>(list.subList(start, end), pageable, list.size());
        }

}

