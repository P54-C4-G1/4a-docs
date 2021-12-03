package com.p54.g1.generalms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class UnidadHabitacionalNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UnidadHabitacionalNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UnidadHabitacionalNotFoundAdvice(UnidadHabitacionalNotFoundException ex) {
        return ex.getMessage();
    }
}
