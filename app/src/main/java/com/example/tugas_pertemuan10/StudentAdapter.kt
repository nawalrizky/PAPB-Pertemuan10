package com.example.tugas_pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_pertemuan10.databinding.ItemStudentBinding

typealias OnClickStudent = (Student) -> Unit

class StudentAdapter(private val listStudents : List<Student>,
                     private val onClickStudent: OnClickStudent):
    RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {
    inner class ItemStudentViewHolder( private val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Student) {
            with(binding) {
                ipkTxt.text = data.ipk
                nameTxt.text = data.name
                imgIcon.setImageResource(data.imageResId) // Set the image resource
                itemView.setOnClickListener {
                    onClickStudent(data)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemStudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStudents.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(listStudents[position])
    }
}