/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saullogax.crud.exception;

import com.saullogax.crud.dto.WebResponse;
import org.springframework.http.HttpStatus;

/**
 *
 * @author saul.lopez
 */
public class ResponseException extends RuntimeException{
    private HttpStatus httpStatus;
    private WebResponse response;

    public ResponseException() {
    }

    public ResponseException(String message) {
        super(message);
    }

    public ResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseException(Throwable cause) {
        super(cause);
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public WebResponse getResponse() {
        return this.response;
    }

    public void setHttpStatus(final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setResponse(final WebResponse response) {
        this.response = response;
    }
}
