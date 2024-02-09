package com.fileextension.entites;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.Map;
@Data
@AllArgsConstructor
public class ErrorMessage {

    private String correlationId;
    private Instant timeStamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;
    private Map<String,Object> fieldLevelErrors;

    public ErrorMessage(){
        this.timeStamp=Instant.now();
    }
}
