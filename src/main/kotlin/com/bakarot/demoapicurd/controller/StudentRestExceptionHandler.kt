package com.bakarot.demoapicurd.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class StudentRestExceptionHandler {
    @ExceptionHandler
    fun handleException(e: Exception): ResponseEntity<StudentErrorResponse> {
        val error: StudentErrorResponse
        val status: HttpStatus
        when (e) {
            is StudentNotFoundException -> {
                status = HttpStatus.NOT_FOUND
                error = StudentErrorResponse(
                    status = status.value(),
                    message = e.message ?: "Student not found",
                    timeStamp = System.currentTimeMillis()
                )
            }

            else -> {
                status = HttpStatus.BAD_REQUEST
                error = StudentErrorResponse(
                    status = status.value(),
                    message = e.message ?: "Bad request",
                    timeStamp = System.currentTimeMillis()
                )
            }
        }
        return ResponseEntity(error, status)
    }
}