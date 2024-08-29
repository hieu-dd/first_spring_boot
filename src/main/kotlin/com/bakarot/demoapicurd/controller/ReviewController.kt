package com.bakarot.demoapicurd.controller

import com.bakarot.demoapicurd.dao.CourseRepository
import com.bakarot.demoapicurd.dao.ReviewRepository
import com.bakarot.demoapicurd.dto.CreateReviewDTO
import com.bakarot.demoapicurd.entity.Review
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@BasePathAwareController
class ReviewController(
    private val courseRepository: CourseRepository,
    private val reviewRepository: ReviewRepository
) {
    @PostMapping("courses/{courseId}/reviews")
    fun createReview(
        @PathVariable courseId: Long,
        @RequestBody createReviewDTO: CreateReviewDTO,
    ): ResponseEntity<Review> {
        val course = courseRepository.findById(courseId).orElseThrow {
            RuntimeException("Course not found: $courseId")
        }
        val dbReview = reviewRepository.save(
            Review(
                comment = createReviewDTO.comment,
                course = course
            )
        )
        return ResponseEntity.ok(dbReview)
    }
}