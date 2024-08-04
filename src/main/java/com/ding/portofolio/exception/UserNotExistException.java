package com.ding.portofolio.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String s) {
        super(s);
    }
}
