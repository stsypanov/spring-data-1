package com.luxoft.logeek.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

@Aspect
@Component
public class RepositoryMethodWrapper {

    @Around("execution(public com.luxoft.logeek.entity.Child com.luxoft.logeek.repository..*.*(..))")
    public Object wrap(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (NoResultException e) {
            return null;
        }
    }
}
