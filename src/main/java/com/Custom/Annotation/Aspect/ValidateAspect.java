package com.Custom.Annotation.Aspect;

import com.Custom.Annotation.Annotations.ValidatePost;
import com.Custom.Annotation.Dto.PostDto;
import com.Custom.Annotation.Exceptions.FieldEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ValidateAspect{
    @Around("@annotation(validatePost)")
    public Object validatePost(ProceedingJoinPoint joinPoint, ValidatePost validatePost) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof PostDto postDto) {

            if (postDto.getNom() == null || postDto.getNom().isEmpty()) {
                log.error("Post name must not be empty");
                throw new FieldEmptyException("name");
            }
            if (postDto.getAuthor() == null || postDto.getAuthor().isEmpty()) {
                log.error("Post author must not be empty");
                throw new FieldEmptyException("author");
            }
        }
        return joinPoint.proceed();
    }
}
