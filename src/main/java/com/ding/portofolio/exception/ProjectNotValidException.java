package com.ding.portofolio.exception;

public class ProjectNotValidException extends RuntimeException {
    public ProjectNotValidException(String projectIsNoValid) {
        super(projectIsNoValid);
    }
}
