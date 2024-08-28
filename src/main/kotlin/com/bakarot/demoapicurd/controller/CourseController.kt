package com.bakarot.demoapicurd.controller

import com.bakarot.demoapicurd.dao.CourseRepository
import com.bakarot.demoapicurd.dao.InstructorRepository
import com.bakarot.demoapicurd.dto.CreateCourseDTO
import com.bakarot.demoapicurd.entity.Course
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/courses")
class CourseController(
    private val courseRepository: CourseRepository,
    private val instructorRepository: InstructorRepository
) {
    @PostMapping
    @Transactional
    fun createCourse(@RequestBody createCourseDTO: CreateCourseDTO) {
        val instructor = instructorRepository.findById(createCourseDTO.instructorId).orElseThrow {
            RuntimeException("Instructor not found: ${createCourseDTO.instructorId}")
        }
        instructor.courses.add(
            Course(
                title = createCourseDTO.title,
                instructor = instructor
            )
        )
        instructorRepository.save(instructor)
    }
}