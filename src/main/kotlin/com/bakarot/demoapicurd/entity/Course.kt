package com.bakarot.demoapicurd.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

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
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "instructor_id")
    @JsonIgnore
    var instructor: Instructor,

    @OneToMany(
        cascade = [CascadeType.ALL, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH],
        fetch = FetchType.LAZY,
        mappedBy = "course"
    )
    var reviews: MutableList<Review> = mutableListOf()
) {

    override fun toString(): String {
        return """
            Course(id=$id,
                    title='$title',
                    )
        """.trimIndent()
    }
}