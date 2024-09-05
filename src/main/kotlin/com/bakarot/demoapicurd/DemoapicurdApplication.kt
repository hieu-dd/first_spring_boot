package com.bakarot.demoapicurd

import com.bakarot.demoapicurd.dao.AccountDao
import com.bakarot.demoapicurd.entity.Student
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoapicurdApplication {
    @Bean
    fun commandLineRunner(accountDao: AccountDao): CommandLineRunner {
        return CommandLineRunner { runner ->
            println(accountDao.addStudent(Student(id = 0, "John", "Doe", "")))
        }
    }
}

fun main(args: Array<String>) {
    runApplication<DemoapicurdApplication>(*args)
}