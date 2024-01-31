package com.CustomerManagement.customerManagement.Services;

import com.CustomerManagement.customerManagement.Entities.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {

    void createCustomer(Customer customer);
    void updateCustomerDetails(String firstname, String lastname, String stre, String addr, String cty, String st, String mail, String phoneno, Long id);

    void deleteCustomer(Long id);
}
