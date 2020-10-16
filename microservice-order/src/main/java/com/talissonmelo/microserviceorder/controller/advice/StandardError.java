package com.talissonmelo.microserviceorder.controller.advice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StandardError {
    private String message;
    private Integer status;
}