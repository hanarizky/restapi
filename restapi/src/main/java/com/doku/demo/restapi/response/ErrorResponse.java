package com.doku.demo.restapi.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponse {

    private Integer status;
    private String message;
    private String[] error;

}
