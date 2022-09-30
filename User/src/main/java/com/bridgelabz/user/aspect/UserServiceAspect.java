package com.bridgelabz.user.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {
    @Before(value = "execution(* com.bridgelabz.user.service.UserService.registerUser(..))")
    public void beforeAddUserData(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature());
        System.out.println("Before Method");
        System.out.println("Want to create new user deatils into the table");
    }

    @After(value = "execution(* com.bridgelabz.user.service.UserService.registerUser(..))")
    public void afterAddUserData(JoinPoint joinPoint){
        String arg = joinPoint.getArgs()[0].toString();
        System.out.println("After Method");
        System.out.println("Successfully created new user details" + arg);
    }

    @Pointcut("within(com.bridgelabz.user..*)")
    public void authorizationPointCut(){

    }

    @Before("authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authenticate the request..");
    }
}
