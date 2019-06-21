package com.doku.demo.restapi.controller;

import com.doku.demo.restapi.model.UserDetailsRequest;
import com.doku.demo.restapi.dto.UserRest;
import com.doku.demo.restapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@Api("User Management Rest API Documentation")
@RestController                 //to able receive http request
@RequestMapping("/users")       // endpoints : http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Search User by ID")
    @GetMapping(value = "/{userId}"                                         // mapping method GET dengan path "/{userId}"
            , produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }
            )
    public ResponseEntity getUser(@PathVariable String userId) {
        UserRest returnValue = userService.getUser(userId);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);        // response jika data berhasil diambil
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);             // response jika data kosong atau tidak ada
        }
    }

    @ApiOperation(value = "Create User")
    @PostMapping(value = "/add" , produces = {                              // mapping method POST dengan path "/add"
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE }
            )
    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequest userDetails)
    {
        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);       //response bahwa data berhasil dibuat
    }

}