package com.talissonmelo.insert.controller.exception;

import com.talissonmelo.insert.service.exception.EntityNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ClientAdvice {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<StandardError> dataViolation(EntityNotFound e , HttpServletRequest request){

        StandardError error = StandardError.builder().message(e.getMessage()).status(HttpStatus.NOT_FOUND.value()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
