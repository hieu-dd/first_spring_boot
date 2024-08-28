package com.bakarot.demoapicurd.entity

import jakarta.persistence.*
import jakarta.persistence.criteria.CriteriaBuilder.In

@Entity
@Table(name = "course")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0,


    @Column(name = "title")
    var title: String,

    @ManyToOne(
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH],
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "instructor_id")
    var instructor: Instructor
) {

    override fun toString(): String {
        return """
            Course(id=$id,
                    title='$title',
                    )
        """.trimIndent()
    }
}