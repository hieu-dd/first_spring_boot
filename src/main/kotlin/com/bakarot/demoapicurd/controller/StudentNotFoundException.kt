package com.bakarot.demoapicurd.controller

class StudentNotFoundException() : RuntimeException() {
    constructor(message: String) : this()
}
