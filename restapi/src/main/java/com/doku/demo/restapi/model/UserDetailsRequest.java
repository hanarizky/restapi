package com.doku.demo.restapi.model;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter @Setter @NotNull
public class UserDetailsRequest {

    private String userId;
    private String fullName;
    private String userName;
    @Email
    private String email;

}