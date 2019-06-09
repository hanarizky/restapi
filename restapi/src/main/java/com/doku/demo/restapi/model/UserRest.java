package com.doku.demo.restapi.model;

import lombok.*;

@Getter @Setter @ToString
public class UserRest {
    private String message;     // Untuk menampilkan application environment
    private String userId;
    private String fullName;
    private String userName;
    private String email;
}
