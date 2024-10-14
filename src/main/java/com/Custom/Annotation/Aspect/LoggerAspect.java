package com.Custom.Annotation.Aspect;

import com.Custom.Annotation.Annotations.RequestLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Component
@Aspect
public class LoggerAspect {

    @Around("@annotation(requestLogger)")
    public Object logRequest(ProceedingJoinPoint joinPoint, RequestLogger requestLogger) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if(requestLogger.enabled()){
            log.debug("Aspect triggered for method: {}", joinPoint.getSignature().getName());
            log.info("{}: Request received", request.getRequestURI());
            Object object = joinPoint.proceed();
            log.info("{}: Request finished", request.getRequestURI());
            return object;
        }else{
            log.warn("{} : Request received but logging is disabled", request.getRequestURI());
            return joinPoint.proceed();
        }
    }
}
