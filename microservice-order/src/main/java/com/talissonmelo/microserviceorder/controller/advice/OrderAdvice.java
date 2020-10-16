package com.talissonmelo.microserviceorder.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.talissonmelo.microserviceorder.service.exception.EntityNotFoundException;

@ControllerAdvice
public class OrderAdvice {

	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> dataViolation(EntityNotFoundException e , HttpServletRequest request){
        StandardError error = StandardError.builder().message(e.getMessage()).status(HttpStatus.NOT_FOUND.value()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
