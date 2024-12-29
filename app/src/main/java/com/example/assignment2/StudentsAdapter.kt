package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter(
    private val students: List<Student>,
    private val onRowClick: (Student) -> Unit,
    private val onCheckClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> (){

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.studentPhoto)
        val name: TextView = view.findViewById(R.id.studentName)
        val id: TextView = view.findViewById(R.id.studentId)
        val checkBox: CheckBox = view.findViewById(R.id.studentCheckBox)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.photo.setImageResource(student.photoResId)
        holder.name.text = student.name
        holder.id.text = student.id
        holder.checkBox.isChecked = student.isChecked

        holder.checkBox.setOnClickListener { onCheckClick(student) }
        holder.itemView.setOnClickListener { onRowClick(student) }
    }

    override fun getItemCount(): Int = students.size

}