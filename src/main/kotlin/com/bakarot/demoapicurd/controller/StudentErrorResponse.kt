package com.bakarot.demoapicurd.controller

data class StudentErrorResponse(
    val status: Int,
    val message: String,
    val timeStamp: Long
)