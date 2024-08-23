package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Student
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class StudentDaoImpl(private val entityManager: EntityManager) : StudentDao {
    @Transactional
    override fun save(student: Student) {
        entityManager.persist(student)
    }

    override fun findById(id: Long): Student? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Student> {
        return entityManager.createQuery("from Student", Student::class.java).resultList
    }

    override fun update(student: Student) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun findStudentByEmail(email: String): Student? {
        TODO("Not yet implemented")
    }

    override fun findStudentByFirstName(firstName: String): List<Student> {
        TODO("Not yet implemented")
    }
}