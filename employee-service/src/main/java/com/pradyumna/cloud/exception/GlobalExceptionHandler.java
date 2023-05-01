package com.pradyumna.cloud.exception;

import com.ctc.wstx.shaded.msv_core.util.Uri;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends Throwable{
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ProblemDetail employeeNotFoundHandler(EmployeeNotFoundException ex){
        ProblemDetail problemDetail  =  ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,ex.getMessage());
        problemDetail.setTitle("Find By Employee ID");
        problemDetail.setType(URI.create("/employee/"));
        return problemDetail;
    }
}
