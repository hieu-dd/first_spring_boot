package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Student

interface StudentDao {
    fun save(student: Student)
    fun findById(id: Long): Student?
    fun findAll(): List<Student>
    fun update(student: Student)
    fun deleteById(id: Long)
    fun findStudentByEmail(email: String): Student?
    fun findStudentByFirstName(firstName: String): List<Student>
}