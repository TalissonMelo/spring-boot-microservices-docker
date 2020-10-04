package com.talissonmelo.insert.service.exception;

public class DataBaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
        public DataBaseException(String message) {
            super(message);
        }
}