package com.example.assignment2

object StudentRepository {
    private val students = mutableListOf<Student>()

    fun getStudents(): List<Student> = students
    fun addStudent(student: Student) = students.add(student)
    fun updateStudent(student: Student) {
        val index = students.indexOfFirst { it.id == student.id }
        if (index != -1) students[index] = student
    }
    fun deleteStudent(student: Student) = students.remove(student)
    fun getStudentById(id: String): Student? = students.find { it.id == id }
}