package com.bakarot.demoapicurd.controller

import com.bakarot.demoapicurd.dao.StudentDao
import com.bakarot.demoapicurd.entity.Student
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
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
    fun getStudents(): List<Student> {
        return studentDao.findAll()
    }

    // define endpoint to get student by id
    @GetMapping("/students/{id}")
    fun getStudentById(@PathVariable id: Long): Student {
        return studentDao.findById(id)!!
    }
}