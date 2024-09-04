package com.bakarot.demoapicurd.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(0) // Order of execution with other aspects
class MyDemoReadJoinPointAspect {
    @Pointcut("execution(* com.bakarot.demoapicurd.dao.*.*(..))")
    fun forPackage() {
    }

    @Before("forPackage()")
    fun beforePackage(joinPoint: JoinPoint) {
        println("\n=====>>> Executing @Before advice on package")

        // Display the method signature
        val method = joinPoint.signature.toShortString()
        println("Method Signature: $method")

        // Display the method arguments
        val args = joinPoint.args
        args.forEachIndexed { index, arg ->
            println("Argument $index: $arg")
        }
    }
}