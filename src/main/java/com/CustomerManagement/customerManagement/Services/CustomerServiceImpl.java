package com.CustomerManagement.customerManagement.Services;

import com.CustomerManagement.customerManagement.DAO.CustomerRepository;
import com.CustomerManagement.customerManagement.Entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

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
}
