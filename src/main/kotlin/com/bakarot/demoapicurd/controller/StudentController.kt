package com.bakarot.demoapicurd.controller

import com.bakarot.demoapicurd.dao.StudentDao
import com.bakarot.demoapicurd.entity.Student
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController(private val studentDao: StudentDao) {

    @GetMapping("/save_student")
    fun saveStudent(): String {
        println("Creating student...")
        val student = Student(
            firstName = "John",
            lastName = "Doe",
            email = "john.doe@gmail.com"
        )
        studentDao.save(student)
        println("Saving student...")
        return "Student saved: $student"
    }

    @GetMapping("/students")
    fun getStudents(): String {
        return studentDao.findAll().joinToString("<br>")
    }
}