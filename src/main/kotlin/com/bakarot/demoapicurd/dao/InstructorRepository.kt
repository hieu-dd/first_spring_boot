package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Instructor
import org.springframework.data.jpa.repository.JpaRepository


interface InstructorRepository : JpaRepository<Instructor, Long>