package com.reactive.shopreactive.web.controller.advice;

import com.reactive.shopreactive.common.ApiException;
import com.reactive.shopreactive.common.exceptions.BadRequestException;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {
    private ApiException responseError;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiException> handleException(BadRequestException ex){
        responseError = constructResponse(HttpStatus.BAD_REQUEST.value(), ex);
        return ResponseEntity.status(responseError.getStatusCode()).body(responseError);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiException> handleNotFoundException(NotFoundException ex){
        responseError = constructResponse(HttpStatus.NOT_FOUND.value(), ex);
        return ResponseEntity.status(responseError.getStatusCode()).body(responseError);
    }

    private ApiException constructResponse(int value, Exception ex) {
        return ApiException.builder()
                .statusCode(value)
                .message(ex.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
    }
}
