package com.talissonmelo.insert.controller.exception;

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
