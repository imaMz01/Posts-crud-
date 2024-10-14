package com.Custom.Annotation.Exceptions;

public class FieldEmptyException extends RuntimeException {
    public FieldEmptyException(String field) {
        super(ExceptionMessages.FIELD_IS_EMPTY.getMessage(field));
    }
}
