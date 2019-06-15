package com.doku.demo.restapi.service;

import com.doku.demo.restapi.model.UserDetailsRequest;
import com.doku.demo.restapi.dto.UserRest;

import java.util.Collection;

public interface UserService {
    UserRest createUser(UserDetailsRequest userDetails);
    UserRest getUser(String userId);
    Collection getUserAll();
    UserRest deleteUser(String userId);
}
