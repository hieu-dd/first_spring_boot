package com.bakarot.demoapicurd.entity

import jakarta.persistence.*

@Entity
@Table(name = "instructor")
data class Instructor(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "email")
    var email: String,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_detail_id")
    var instructorDetail: InstructorDetail
)

@Entity
@Table(name = "instructor_detail")
data class InstructorDetail(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "youtube_channel")
    var youtubeChannel: String,

    @Column(name = "hobby")
    var hobby: String,
)