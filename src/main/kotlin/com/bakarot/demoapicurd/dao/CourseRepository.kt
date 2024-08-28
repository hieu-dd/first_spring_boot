package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository :JpaRepository<Course, Long> {
}