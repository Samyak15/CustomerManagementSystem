package com.CustomerManagement.customerManagement.Services;

import com.CustomerManagement.customerManagement.Entities.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    void createCustomer(Customer customer);
}
