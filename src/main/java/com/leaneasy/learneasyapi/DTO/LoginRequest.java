package com.leaneasy.learneasyapi.DTO;

import lombok.Getter;
import lombok.Setter;
//La clase LoginRequest es el objeto que representa los datos que envía el cliente al hacer login:
@Getter
@Setter
public class LoginRequest {
    private String email;
    private String password;
}
