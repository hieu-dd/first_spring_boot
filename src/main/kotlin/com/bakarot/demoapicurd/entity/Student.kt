package com.bakarot.demoapicurd.entity

import jakarta.persistence.*

@Entity
@Table(name = "student")
data class Student(
    @Column(name = "first_name")
    var firstName: String,
    @Column(name = "last_name")
    var lastName: String,
    @Column(name = "email")
    var email: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

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