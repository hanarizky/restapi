package com.doku.demo.restapi.dto;

import lombok.*;

@Getter @Setter @ToString
public class UserRest {

    private String message;     // to assure the application.properties is success
    private String userId;
    private String fullName;
    private String userName;
    private String email;

}
