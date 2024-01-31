package com.CustomerManagement.customerManagement.Controllers;

import com.CustomerManagement.customerManagement.Entities.Customer;
import com.CustomerManagement.customerManagement.Models.CustomerModifyreq;
import com.CustomerManagement.customerManagement.Services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/createCustomer")
    public void createNewCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }
    @Modifying
    @PutMapping("/updateCustomer")
    public void updateCustomerDetails(@RequestBody CustomerModifyreq customerModifyreq){
        System.out.println("controller");
        String fn = customerModifyreq.getFirstname();
        String ln = customerModifyreq.getLastname();
        String str = customerModifyreq.getStreet();
        String add = customerModifyreq.getAddress();
        String ci = customerModifyreq.getCity();
        String st = customerModifyreq.getState();
        String em = customerModifyreq.getEmail();
        String pn = customerModifyreq.getPhone();
        Long id = customerModifyreq.getId();
        customerService.updateCustomerDetails(fn,ln,str,add,ci,st,em,pn,id);
    }

    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestParam Long id){
        customerService.deleteCustomer(id);
    }
}
