package com.fileextension.exception;

public class InvaildFileExtensionException extends RuntimeException {
    private String correlationId;
    public InvaildFileExtensionException(String message,String correlationId) {
        super(message);
        this.correlationId=correlationId;
    }

    public String getCorrelationId(){
        return correlationId;
    }
}
