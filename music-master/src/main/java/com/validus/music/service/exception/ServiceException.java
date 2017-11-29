package com.validus.music.service.exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -3681636607322599994L;

    public ServiceException(String message) {
        super(message);
    }
}
