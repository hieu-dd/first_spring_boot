package com.bakarot.demoapicurd.dao

import com.bakarot.demoapicurd.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface ReviewRepository : JpaRepository<Review, Long>