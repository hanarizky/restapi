package com.doku.demo.restapi.service.impl;

import com.doku.demo.restapi.model.UserDetailsRequest;
import com.doku.demo.restapi.dto.UserRest;
import com.doku.demo.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;



@Service("UserService")
public class UserServiceImpl implements UserService {

    @Value("${message.default.welcome}")         // Mengambil parameter pada application.properties
    private String envMessage;

    UserRest returnValue;

    HashMap<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequest userDetails) {
        returnValue = new UserRest();

        returnValue.setMessage(envMessage);

        returnValue.setUserId(userDetails.getUserId());
        String userId = returnValue.getUserId();

        returnValue.setFullName(userDetails.getFullName());
        returnValue.setUserName(userDetails.getUserName());
        returnValue.setEmail(userDetails.getEmail());

        if (users == null ) {
            users = new HashMap<>();
            users.put(userId, returnValue);
        }

        return returnValue;
    }

    public UserRest getUser (String userId) {
            return users.get(userId);
    }
}
