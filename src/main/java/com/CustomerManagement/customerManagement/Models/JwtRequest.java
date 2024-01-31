package com.CustomerManagement.customerManagement.Models;


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtRequest{

    private String email;
    private String password;
}
