package com.CustomerManagement.customerManagement.Models;


import lombok.*;

import java.io.Serializable;

//This is model class for jwt Response
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JwtResponse{
    private String jwtToken;
    private String username;
}
