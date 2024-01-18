package com.diplomado.springboot.web.rest.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final String message;

    private final HttpStatus httpStatus;

    private ZonedDateTime time;

    public String getMessage() {
        return message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime time) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = time;
    }
}