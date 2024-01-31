package com.CustomerManagement.customerManagement.Controllers;

import com.CustomerManagement.customerManagement.Entities.Customer;
import com.CustomerManagement.customerManagement.Services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/createCustomer")
    public void createNewCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }
}
