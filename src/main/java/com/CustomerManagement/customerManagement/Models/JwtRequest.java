package com.CustomerManagement.customerManagement.Models;


import lombok.*;

import java.io.Serializable;

//This is model class for JwtRequest
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtRequest{
    private String email;
    private String password;
}
