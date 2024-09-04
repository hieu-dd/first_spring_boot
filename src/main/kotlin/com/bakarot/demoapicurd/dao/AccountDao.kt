package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Student
import org.springframework.stereotype.Component


interface AccountDao {
    fun addAccount()
    fun addStudent(student: Student)
}

@Component
class AccountDaoImpl : AccountDao {
    override fun addAccount() {
        println("Account added")
    }

    override fun addStudent(student: Student) {
        println(
            "Student added: " +
                    "ID: ${student.id}, " +
                    "Name: ${student.firstName}, " +
                    "Email: ${student.email}"
        )
    }
}