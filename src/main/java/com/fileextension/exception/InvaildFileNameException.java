package com.fileextension.exception;

public class InvaildFileNameException extends RuntimeException {

    private String correlationId;
    public InvaildFileNameException(String message,String  correlationId) {
        super( message);
        this.correlationId=correlationId;
    }

    public String getCorrelationId(){
        return correlationId;
    }
}
