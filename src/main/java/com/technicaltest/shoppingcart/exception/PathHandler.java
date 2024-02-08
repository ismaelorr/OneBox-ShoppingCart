package com.technicaltest.shoppingcart.exception;

import com.technicaltest.shoppingcart.model.constants.StringConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PathHandler {

    private StringConstants stringConstants = new StringConstants();

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String nullPointerHandler(NullPointerException exception){
        return stringConstants.NULL_POINTER_EXCEPTION_MESSAGE;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String illegalArgumentHandler(IllegalArgumentException exception){
        return stringConstants.ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String messageNotRedableHandler(HttpMessageNotReadableException exception){
        return stringConstants.HTTP_NOT_REDEABLE_EXCEPTION_MESSAGE;
    }


}

