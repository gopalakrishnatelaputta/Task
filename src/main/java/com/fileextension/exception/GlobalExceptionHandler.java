package com.fileextension.exception;

import com.fileextension.entites.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvaildFileExtensionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleInvalidFileExtensionException(InvaildFileExtensionException ex, HttpServletRequest request) {
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setCorrelationId(ex.getCorrelationId());
        errorMessage.setTimeStamp(errorMessage.getTimeStamp());
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setError(ex.getMessage());
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setPath(request.getRequestURI());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }



    @ExceptionHandler(InvaildFileNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleInvalidFileNameException(InvaildFileNameException ex, HttpServletRequest request) {
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setCorrelationId(ex.getCorrelationId());
        errorMessage.setTimeStamp(errorMessage.getTimeStamp());
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setError(ex.getMessage());
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setPath(request.getRequestURI());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }



}
