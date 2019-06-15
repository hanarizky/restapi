package com.doku.demo.restapi.controller;

import com.doku.demo.restapi.response.DeleteResponse;
import com.doku.demo.restapi.exception.MemberNotFoundException;
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
import java.util.Collection;


@Api("User Management Rest API Documentation")      // will be shown at Swagger UI
@RestController                                     // to able receive http request
@RequestMapping("/users")                           // endpoints : http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Create User")
    @PostMapping( produces = {                              // mapping POST method
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {
                    MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE
            } )
    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequest userDetails) {

        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);       //response if data created

    }

    @ApiOperation(value = "Search User by ID")
    @GetMapping(value = "/{userId}"                                         // mapping GET method with path "users/{userId}"
            , produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
    } )
    public ResponseEntity getUser(@PathVariable String userId) {

        UserRest returnValue = userService.getUser(userId);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);        // response if success get the data
        } else {
            throw new MemberNotFoundException();            // response if the data is not found
        }

    }

    @ApiOperation(value = "Search all user")
    @GetMapping
    public ResponseEntity getUserAll(){

        Collection returnValue = userService.getUserAll();
        return new ResponseEntity(returnValue,HttpStatus.OK);
    }

    @ApiOperation(value = "Delete member")
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<DeleteResponse> deleteMember(@PathVariable String userId) {

        UserRest returnValue = userService.deleteUser(userId);

        if (returnValue != null) {
            return ResponseEntity.ok(new DeleteResponse("User deleted!"));
        } else {
            throw new MemberNotFoundException();
        }
    }

}