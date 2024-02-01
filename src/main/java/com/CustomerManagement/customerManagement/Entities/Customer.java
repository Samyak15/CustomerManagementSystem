package com.CustomerManagement.customerManagement.Entities;

import jakarta.persistence.*;
import lombok.*;

//This is our Customer Entity Class
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class Customer {

    //Defining all the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "street")
    private String street;
    @Column(name = "address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
}
