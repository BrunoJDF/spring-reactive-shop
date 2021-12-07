package com.reactive.shopreactive.web.controller.advice;

import com.reactive.shopreactive.common.ApiException;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(reason = "No existe")
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handleException(Exception ex){
        ApiException responseError = ApiException.builder()
                .message(ex.getMessage())
                .build();
        if(ex instanceof NotFoundException){
            responseError.setStatusCode(HttpStatus.NOT_FOUND.value());
        } else {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.status(responseError.getStatusCode()).body(responseError);
    }
}
