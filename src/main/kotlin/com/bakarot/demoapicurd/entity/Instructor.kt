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

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    var instructorDetail: InstructorDetail,

    @OneToMany(
        mappedBy = "instructor",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH],
        fetch = FetchType.LAZY
    )
    var courses: MutableList<Course> = mutableListOf()
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