package com.pradyumna.cloud.exception;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends Throwable{
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ProblemDetail departmentNotFoundHandler(DepartmentNotFoundException ex){
        ProblemDetail problemDetail  =  ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage());
        problemDetail.setTitle("Find By Department ID");
        problemDetail.setType(URI.create("/department/"));
        return problemDetail;
    }
}
