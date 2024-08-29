package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(exported = true)
interface CourseRepository : JpaRepository<Course, Long> {
}