package com.pradyumna.cloud.exception;

import com.pradyumna.cloud.controller.OrganizationController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends Throwable{
    @ExceptionHandler(OrganizationNotFoundException.class)
    public ProblemDetail organizationNotFoundHandler(OrganizationNotFoundException ex){
        ProblemDetail problemDetail  =  ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage());
        problemDetail.setType(URI.create("/organization/"));
        problemDetail.setTitle("Find By Organisation ID");
        return problemDetail;
    }
}
