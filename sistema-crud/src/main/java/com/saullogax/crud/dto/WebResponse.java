/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saullogax.crud.dto;

import java.io.Serializable;

/**
 *
 * @author saul.lopez
 */
public class WebResponse implements Serializable{
    
    private short type;
    private String message;
    private Object data;
    
    public WebResponse(final short type, final String message, final Object data) {
        this.type = type;
        this.message = message;
        this.data = data;
    }

    public WebResponse() {
    }

    public short getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public void setType(final short type) {
        this.type = type;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setData(final Object data) {
        this.data = data;
    }
    
    public String toString() {
        return "WebResponseDTO(type=" + this.getType() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
    
}
