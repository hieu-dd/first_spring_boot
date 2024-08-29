package com.bakarot.demoapicurd.controller

import com.bakarot.demoapicurd.dao.CourseRepository
import com.bakarot.demoapicurd.dao.InstructorRepository
import com.bakarot.demoapicurd.dao.StudentRepository
import com.bakarot.demoapicurd.dto.CreateCourseDTO
import com.bakarot.demoapicurd.entity.Course
import jakarta.transaction.Transactional
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@BasePathAwareController
class CourseController(
    private val instructorRepository: InstructorRepository,
    private val courseRepository: CourseRepository,
    private val studentRepository: StudentRepository
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
        val courseDb = courseRepository.save(
            Course(
                title = createCourseDTO.title,
                instructor = instructor
            )
        )
        return ResponseEntity.ok(courseDb)
    }

    @PutMapping("instructors/{instructorId}/courses/{courseId}")
    @Transactional
    fun updateCourse(
        @PathVariable instructorId: Long,
        @PathVariable courseId: Long,
        @RequestBody createCourseDTO: CreateCourseDTO
    ): ResponseEntity<Course> {
        val instructor = instructorRepository.findById(instructorId).orElseThrow {
            RuntimeException("Instructor not found: $instructorId")
        }
        val course = courseRepository.findById(courseId).orElseThrow {
            RuntimeException("Course not found: $courseId")
        }
        course.title = createCourseDTO.title
        course.instructor = instructor
        courseRepository.save(course)
        return ResponseEntity.ok(course)
    }

    @PutMapping("courses/{courseId}/students/{studentId}")
    @Transactional
    fun addStudentToCourse(
        @PathVariable courseId: Long,
        @PathVariable studentId: Long
    ): ResponseEntity<Boolean> {
        val course = courseRepository.findById(courseId).orElseThrow {
            RuntimeException("Course not found: $courseId")
        }
        val student = studentRepository.findById(studentId).orElseThrow {
            RuntimeException("Student not found: $studentId")
        }
        course.students.add(student)
        courseRepository.save(course)
        return ResponseEntity.ok(true)
    }
}