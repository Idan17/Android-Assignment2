package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val studentId = intent.getStringExtra("studentId")
        val student = StudentRepository.getStudentById(studentId!!)

        val nameText = findViewById<TextView>(R.id.student_details_activity_name_text)
        val idText = findViewById<TextView>(R.id.student_details_activity_id_text)
        val btnEdit = findViewById<Button>(R.id.student_details_activity_edit_button)
        val checkbox = findViewById<CheckBox>(R.id.student_details_activity_checkbox)
        nameText.text = student?.name
        idText.text = student?.id
        checkbox.isChecked = student!!.isChecked
        btnEdit.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("studentId", studentId)
            startActivity(intent)
        }
    }
}