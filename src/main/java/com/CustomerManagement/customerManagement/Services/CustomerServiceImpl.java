package com.CustomerManagement.customerManagement.Services;

import com.CustomerManagement.customerManagement.DAO.CustomerRepository;
import com.CustomerManagement.customerManagement.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
