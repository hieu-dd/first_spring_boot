package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Student
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit


interface AccountDao {
    fun addAccount()
    fun addStudent(student: Student): List<Student>
    fun findStudent(id: Long): List<Student>
}

@Component
class AccountDaoImpl : AccountDao {
    override fun addAccount() {
        println("Account added")
    }

    override fun addStudent(student: Student): List<Student> {
        return listOf(student)
    }

    override fun findStudent(id: Long): List<Student> {
        TimeUnit.SECONDS.sleep(5)
        if (id == 1L) {
            return listOf(Student(1, "John", "Doe", ""))
        } else {
            throw RuntimeException("Student not found")
        }
    }
}