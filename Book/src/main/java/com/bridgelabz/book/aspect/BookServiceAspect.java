package com.bridgelabz.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookServiceAspect {
    @Before(value = "execution(* com.bridgelabz.book.service.BookService.insertBook(..))")
    public void beforeAddBookData(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        System.out.println("Before Method");
        System.out.println("Want to create new book details into the table");
    }

    @After(value = "execution(* com.bridgelabz.book.service.BookService.insertBook(..))")
    public void afterAddBookData(JoinPoint joinPoint){
        String arg = joinPoint.getArgs()[0].toString();
        System.out.println("After Method");
        System.out.println("Successfully created new book details" + arg);
    }

    @Pointcut("within(com.bridgelabz.book..*)")
    public void authorizationPointCut(){

    }

    @Before("authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authenticate the request..");
    }

}
