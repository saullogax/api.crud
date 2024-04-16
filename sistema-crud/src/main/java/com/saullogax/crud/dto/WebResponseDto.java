package com.saullogax.crud.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.http.HttpStatus;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WebResponseDto {

    private HttpStatus httpStatus;
    
    @XmlElement(name = "message", required = false, nillable = false, defaultValue = "OK")
    private String message = "OK";

    @XmlElement(name = "type", required = false, nillable = false, defaultValue = "0")
    private int type = 0;

    @XmlElement(name = "data", required = false, nillable = true)
    private Object data = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
     public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    
    public String toString() {
        return "WebResponseDTO(type=" + this.getType() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
