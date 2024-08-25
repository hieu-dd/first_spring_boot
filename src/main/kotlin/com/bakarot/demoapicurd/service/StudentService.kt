package com.bakarot.demoapicurd.service

import com.bakarot.demoapicurd.controller.StudentNotFoundException
import com.bakarot.demoapicurd.dao.StudentRepository
import com.bakarot.demoapicurd.entity.Student
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

interface StudentService {
    fun findAll(): List<Student>
    fun findById(id: Long): Student
    fun save(student: Student): Student
    fun deleteById(id: Long): Student
}

@Service
class StudentServiceImpl(private val studentRepository: StudentRepository) : StudentService {
    override fun findAll(): List<Student> {
        return studentRepository.findAll()
    }

    override fun findById(id: Long): Student =
        studentRepository.findById(id).orElseThrow { StudentNotFoundException("Student not found with id: $id") }

    @Transactional
    override fun save(student: Student): Student {
        val dbStudent = studentRepository.save(student)
        return dbStudent
    }

    @Transactional
    override fun deleteById(id: Long): Student {
        val student = findById(id)
        studentRepository.delete(student)
        return student
    }
}