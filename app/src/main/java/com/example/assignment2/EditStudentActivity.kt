package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment2.model.StudentRepository

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val studentId = intent.getStringExtra("studentId")
        val student = StudentRepository.getStudentById(studentId!!)

        val nameInput = findViewById<EditText>(R.id.edit_student_activity_input_name)
        val idInput = findViewById<EditText>(R.id.edit_student_activity_input_Id)
        val checkboxInput = findViewById<CheckBox>(R.id.edit_student_activity_student_CheckBox)

        val btnSave = findViewById<Button>(R.id.edit_student_activity_save_button)
        val btnDelete = findViewById<Button>(R.id.edit_student_activity_delete_button)
        val btnCancel = findViewById<Button>(R.id.edit_student_activity_cancel_button)

        checkboxInput.isChecked = student!!.isChecked
        nameInput.setText(student?.name)
        idInput.setText(student?.id)

        btnSave.setOnClickListener {
            student?.isChecked = checkboxInput.isChecked
            student?.name = nameInput.text.toString()
            student?.id = idInput.text.toString()
            StudentRepository.updateStudent(student!!)
            startActivity(Intent(this, StudentsListActivity::class.java))
        }

        btnDelete.setOnClickListener {
            StudentRepository.deleteStudent(student!!)
            startActivity(Intent(this, StudentsListActivity::class.java))

        }

        btnCancel.setOnClickListener {
            finish()
        }
    }
}