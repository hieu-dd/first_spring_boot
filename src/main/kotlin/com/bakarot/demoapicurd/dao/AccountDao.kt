package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Student
import org.springframework.stereotype.Component


interface AccountDao {
    fun addAccount()
    fun addStudent(student: Student): List<Student>
}

@Component
class AccountDaoImpl : AccountDao {
    override fun addAccount() {
        println("Account added")
    }

    override fun addStudent(student: Student): List<Student> {
        return listOf(student)
    }
}