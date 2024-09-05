package com.bakarot.demoapicurd.aspect

import com.bakarot.demoapicurd.entity.Student
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Aspect
@Component
@Order(0) // Order of execution with other aspects
class MyDemoReadJoinPointAspect {
    @Pointcut("execution(* com.bakarot.demoapicurd.dao.*.*(..))")
    fun forPackage() {
    }

    // Before advice
    // Call this advice before the method is called
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

    // After returning advice
    // Call this advice when the method returns a value
    @AfterReturning(
        pointcut = "forPackage()",
        returning = "result"
    )
    fun afterReturningPackage(joinPoint: JoinPoint, result: Throwable) {
        println("\n=====>>> Executing @AfterReturning advice on package")

        // Display the method signature
        val method = joinPoint.signature.toShortString()
        println("Method Signature: $method")

        // Display the method return value
        println("Return Value: $result")
        (result as List<*>).forEach {
            (it as Student).firstName = "Mr. ${it.firstName}"
        }
    }

    // After throwing advice
    // Call this advice when an exception is thrown
    @AfterThrowing(
        pointcut = "forPackage()",
        throwing = "exception"
    )
    fun afterThrowingPackage(joinPoint: JoinPoint, exception: Throwable) {
        println("\n=====>>> Executing @AfterThrowing advice on package")

        // Display the method signature
        val method = joinPoint.signature.toShortString()
        println("Method Signature: $method")

        // Display the exception
        println("Exception: $exception")
    }

    // After advice
    // Call this advice after the method is called
    @After("forPackage()")
    fun afterPackage(joinPoint: JoinPoint) {
        println("\n=====>>> Executing @After advice on package")

        // Display the method signature
        val method = joinPoint.signature.toShortString()
        println("Method Signature: $method")
    }

    @Around("forPackage()")
    fun aroundPackage(joinPoint: ProceedingJoinPoint): Any {
        val start = System.currentTimeMillis()
             println("\n=====>>> Executing @Around advice on package")

        // Display the method signature
        val method = joinPoint.signature.toShortString()
        println("Method Signature: $method")

        // Display the method arguments
        val args = joinPoint.args
        args.forEachIndexed { index, arg ->
            println("Argument $index: $arg")
        }

        // Execute the method
        val result = try {
            joinPoint.proceed()
        } catch (e: Throwable) {
            println("Exception: ${e.message}")
            listOf<Student>()
        }

        // Display the method return value
        println("Return Value: $result")
        (result as? List<*>)?.forEach {
            (it as Student).firstName = "Mr. ${it.firstName}"
        }

        val end = System.currentTimeMillis()
        println("Duration: ${end - start} ms")

        return result
    }
}