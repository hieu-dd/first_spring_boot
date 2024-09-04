package com.bakarot.demoapicurd.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(1) // Order of execution with other aspects
class MyDemoLoggingAspect {

    // Pointcut for addAccount method
    @Pointcut("execution(public void com.bakarot.demoapicurd..*.addAccount(..))")
    fun forAddAccount() {
    }

    // Before advice for addAccount method
    @Before("forAddAccount()")
    fun beforeAddAccountAdvice() {
        println("\n=====>>> Executing @Before advice on addAccount()")
    }

    // Reuse the pointcut for another advice
    @Before("forAddAccount()")
    fun beforeAddAccountAdvice2() {
        println("\n=====>>> Executing 2 @Before advice on addAccount()")
    }

    // Pointcut for all methods in the package
    @Pointcut("execution(* com.bakarot.demoapicurd.dao.*.*(..))")
    fun forPackage() {
    }

    // Pointcut for all methods in the package except addAccount
    @Pointcut("forPackage() && !forAddAccount()")
    fun forPackageNoAddAccount() {
    }

    // Before advice for all methods in the package except addAccount
    @Before("forPackageNoAddAccount()")
    fun beforePackage() {
        println("\n=====>>> Executing @Before advice on package")
    }

    // Pointcut for all setter methods
    @Pointcut("execution(* com.bakarot.demoapicurd..*.set*(..))")
    fun setter() {
    }

    // Pointcut for all methods in the Student class
    @Pointcut("execution(* com.bakarot.demoapicurd..Student.*(..))")
    fun getter() {
    }
}