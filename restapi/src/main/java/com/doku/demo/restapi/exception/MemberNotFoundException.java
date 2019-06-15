package com.doku.demo.restapi.exception;

public class MemberNotFoundException extends RuntimeException {

        public MemberNotFoundException(){
            super("The user ID is invalid");
        }

}
