package com.p54.g1.generalms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class GastoNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(GastoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String GastoNotFoundAdvice(GastoNotFoundException ex) {
        return ex.getMessage();
    }
}
