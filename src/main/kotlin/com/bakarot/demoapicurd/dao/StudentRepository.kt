package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long>