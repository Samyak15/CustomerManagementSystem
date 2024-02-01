package com.CustomerManagement.customerManagement.Controllers;

import com.CustomerManagement.customerManagement.Dto.CustomerDto;
import com.CustomerManagement.customerManagement.Entities.Customer;
import com.CustomerManagement.customerManagement.Models.CustomerModifyreq;
import com.CustomerManagement.customerManagement.Services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


//This is the Rest Controller for Customer Class
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {
    //Defining all the fields
    @Autowired
    private CustomerServiceImpl customerService;

    //Post mapping for creating a new customer
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createCustomer")
    public ResponseEntity<String> createNewCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

    //Put Mapping for updating the customer details
    @Modifying
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomerDetails(@RequestBody CustomerModifyreq customerModifyreq) {
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
        customerService.updateCustomerDetails(fn, ln, str, add, ci, st, em, pn, id);

        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

    //Delete Mapping for deleting a customer
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<String> deleteCustomer(@RequestParam Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

    //Get Mapping for getting a particular customer based on id
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Optional<Customer> getCustomerUsingId(@PathVariable("id") Long id) {
        return customerService.getCustomerByid(id);
    }

    //Get Mapping for get the all Customers page based on the param provided to us
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllCustomers")
    public Page<CustomerDto> getCustomerPage(@RequestParam Optional<String> searchtype, Optional<String> searchval, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size, @RequestParam Optional<String> sortby) {
        Page<Customer> customerPage = customerService.findAllCustomers(searchtype, searchval, page, size, sortby);
        return customerPage.map(this::convertToDTO);
    }

    private CustomerDto convertToDTO(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setStreet(customer.getStreet());
        customerDto.setAddress(customer.getAddress());
        customerDto.setCity(customer.getCity());
        customerDto.setState(customer.getState());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone((customer.getPhone()));
        return customerDto;
    }

}
