package com.bakarot.demoapicurd.controller

import com.bakarot.demoapicurd.entity.Student
import com.bakarot.demoapicurd.service.StudentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class StudentController(private val studentService: StudentService) {

    @PostMapping("/students")
    fun saveStudent(@RequestBody student: Student): Student {
        println("Saving student...")
        return studentService.save(student)
    }

    @GetMapping("/students")
    fun getStudents(): List<Student> {
        return studentService.findAll()
    }

    // define endpoint to get student by id
    @GetMapping("/students/{id}")
    fun getStudentById(@PathVariable id: Long): Student {
        return try {
            studentService.findById(id) ?: throw StudentNotFoundException("Student not found with id: $id")
        } catch (e: Exception) {
            throw StudentNotFoundException(e.message ?: "Student not found with id: $id")
        }
    }

    @PutMapping("/students/{id}")
    fun updateStudent(@RequestBody student: Student, @PathVariable id: Long): Student {
        return studentService.save(student.apply {
            this.id = id
        })
    }

    @DeleteMapping("/students/{id}")
    fun deleteStudent(@PathVariable id: Long): Student {
        return studentService.deleteById(id)
    }
}