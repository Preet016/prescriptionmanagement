package com.preet.prescriptionmanagement.exception;

public class InvalidFieldException extends RuntimeException {
    public InvalidFieldException(String field, String message) {
        super("Invalid value provided for " + field + ". " + message);
    }
}
