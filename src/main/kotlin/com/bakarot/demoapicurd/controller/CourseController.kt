package com.bakarot.demoapicurd.controller

import com.bakarot.demoapicurd.dao.CourseRepository
import com.bakarot.demoapicurd.dao.InstructorRepository
import com.bakarot.demoapicurd.dto.CreateCourseDTO
import com.bakarot.demoapicurd.entity.Course
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/instructors/{instructorId}/courses/")
class CourseController(
    private val courseRepository: CourseRepository,
    private val instructorRepository: InstructorRepository
) {
    @PostMapping
    @Transactional
    fun createCourse(@PathVariable instructorId: Long, @RequestBody createCourseDTO: CreateCourseDTO) {
        val instructor = instructorRepository.findById(instructorId).orElseThrow {
            RuntimeException("Instructor not found: $instructorId")
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