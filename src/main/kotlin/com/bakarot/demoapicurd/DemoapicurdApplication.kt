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
            try {
                println(accountDao.findStudent(2))
            } catch (e: Exception) {
                println("Main Exception: ${e.message}")
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<DemoapicurdApplication>(*args)
}