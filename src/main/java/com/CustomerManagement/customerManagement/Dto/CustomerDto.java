package com.CustomerManagement.customerManagement.Dto;

import lombok.*;

@Getter
@Setter
public class CustomerDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String street;

    private String address;

    private String city;

    private String state;

    private String email;

    private String phone;
}
