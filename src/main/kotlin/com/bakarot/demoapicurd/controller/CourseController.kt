package com.bakarot.demoapicurd.controller

import com.bakarot.demoapicurd.dao.CourseRepository
import com.bakarot.demoapicurd.dao.InstructorRepository
import com.bakarot.demoapicurd.dto.CreateCourseDTO
import com.bakarot.demoapicurd.entity.Course
import jakarta.transaction.Transactional
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@BasePathAwareController
class CourseController(
    private val instructorRepository: InstructorRepository,
    private val courseRepository: CourseRepository
) {
    @RequestMapping("instructors/{instructorId}/courses", method = [RequestMethod.POST])
    @Transactional
    fun createCourse(
        @PathVariable instructorId: Long,
        @RequestBody createCourseDTO: CreateCourseDTO
    ): ResponseEntity<Course> {
        val instructor = instructorRepository.findById(instructorId).orElseThrow {
            RuntimeException("Instructor not found: $instructorId")
        }
        val course = Course(
            title = createCourseDTO.title,
            instructor = instructor
        )
        instructor.courses.add(course)
        instructorRepository.save(instructor)
        return ResponseEntity.ok(course)
    }
}