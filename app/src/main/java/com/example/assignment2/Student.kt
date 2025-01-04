package com.example.assignment2

data class Student(
    var id: String,       // ID of the student (editable)
    var name: String,     // Name of the student (editable)
    var isChecked: Boolean, // Checkbox status (checked/unchecked)
    var photoResId: Int   // Resource ID for the student's static photo
)