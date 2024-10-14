package com.Custom.Annotation.Exceptions;

public class PostNotFound extends RuntimeException {
    public PostNotFound(String id) {
        super(ExceptionMessages.POST_NOT_FOUND.getMessage(id));
    }
}
