package com.preet.prescriptionmanagement.advice;

import com.preet.prescriptionmanagement.exception.InvalidFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidFieldAdvice {
    @ResponseBody
    @ExceptionHandler(InvalidFieldException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidFieldAdviceHandler(InvalidFieldException ex) {
        return ex.getMessage();
    }
}

