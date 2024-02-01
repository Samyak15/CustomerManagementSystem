package com.CustomerManagement.customerManagement.Models;

import lombok.Getter;
import lombok.Setter;

// This is our model class for Customer Modify Request
@Getter
@Setter
public class CustomerModifyreq {

    private String firstname;
    private String lastname;
    private String street;
    private String address;
    private String city;
    private String state;
    private String email;
    private String phone;
    private Long id;
}
