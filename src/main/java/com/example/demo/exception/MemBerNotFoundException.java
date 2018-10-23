package com.example.demo.exception;

public class MemBerNotFoundException extends RuntimeException {
    public MemBerNotFoundException(String message) {
        super(message);
    }
}
