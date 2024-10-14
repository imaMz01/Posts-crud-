package com.Custom.Annotation.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessages {

    POST_NOT_FOUND("Post with id %s doesn't exist."),
    FIELD_IS_EMPTY("Post %s must not be null");
    private final String message;


    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
