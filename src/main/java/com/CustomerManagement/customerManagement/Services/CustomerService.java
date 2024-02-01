package com.CustomerManagement.customerManagement.Services;

import com.CustomerManagement.customerManagement.Dto.CustomerDto;
import com.CustomerManagement.customerManagement.Entities.Customer;
import com.CustomerManagement.customerManagement.Models.searchreq;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {

    void createCustomer(Customer customer);
    void updateCustomerDetails(String firstname, String lastname, String stre, String addr, String cty, String st, String mail, String phoneno, Long id);
    void deleteCustomer(Long id);
    Optional<Customer> getCustomerByid(Long id);

    Page<Customer> findAllCustomers(Optional<String> searchtype,Optional<String> serachval, Optional<Integer> Page, Optional<Integer> size, Optional<String> sortBy);


}
