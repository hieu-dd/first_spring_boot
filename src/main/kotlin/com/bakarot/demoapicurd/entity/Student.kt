package com.bakarot.demoapicurd.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "student")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("user_id")
    var id: Long = 0,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "email")
    var email: String,

    @ManyToMany(
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH],
        fetch = FetchType.LAZY
    )
    @JoinTable(
        name = "course_student",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "course_id")]
    )
    @JsonIgnore
    var courses: MutableList<Course> = mutableListOf()
) {
    override fun toString(): String {
        return """
            Student(id=$id,
                    firstName='$firstName',
                    lastName='$lastName',
                    email='$email'
                    )
        """.trimIndent()
    }
}