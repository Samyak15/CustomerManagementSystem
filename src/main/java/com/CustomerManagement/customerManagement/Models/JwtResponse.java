package com.CustomerManagement.customerManagement.Models;


import lombok.*;

import java.io.Serializable;

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
