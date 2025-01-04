package com.example.assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameInput = findViewById<EditText>(R.id.new_student_activity_name_input)
        val idInput = findViewById<EditText>(R.id.new_student_activity_id_input)
        val btnAdd = findViewById<Button>(R.id.new_student_activity_add_button)

        btnAdd.setOnClickListener {
            val name = nameInput.text.toString()
            val id = idInput.text.toString()
            if (name.isNotBlank() && id.isNotBlank()) {
                StudentRepository.addStudent(
                    Student(id, name, false, R.drawable.static_student_image)
                )
                finish() // Return to the previous screen
            }
        }
        val btnCancel = findViewById<Button>(R.id.new_student_activity_cancel_button)

        btnCancel.setOnClickListener {
            finish() // Return to the previous screen
        }
    }


}