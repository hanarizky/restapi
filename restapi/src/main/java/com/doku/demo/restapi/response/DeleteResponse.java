package com.doku.demo.restapi.response;

import lombok.Getter;

@Getter
public class DeleteResponse {

    private String message;

    public DeleteResponse(String message){
        this.message = message;
    }
}
