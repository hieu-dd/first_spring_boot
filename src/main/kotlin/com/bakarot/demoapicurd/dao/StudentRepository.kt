package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

//@RepositoryRestResource(path = "members"): Use it for customizing the path of the API
interface StudentRepository : JpaRepository<Student, Long>