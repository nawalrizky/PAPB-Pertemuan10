package com.example.tugas_pertemuan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas_pertemuan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterStudent = StudentAdapter(generateStudentData()) {
                student ->
            Toast.makeText(this@MainActivity, " ${student.name}",
                Toast.LENGTH_SHORT).show()
        }


        with(binding) {
            rvStudent.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateStudentData(): List<Student> {
        return listOf(
            Student(name = "Nawal Rizky", ipk = "3.6", imageResId = R.drawable.ic_avatar),
            Student(name = "Darriel Markerizal", ipk = "3.65", imageResId = R.drawable.ic_ava1),
            Student(name = "Yodhimas Geffananda", ipk = "3.65", imageResId = R.drawable.ic_ava2),
            Student(name = "Rizky Aziz", ipk = "3.8", imageResId = R.drawable.ic_ava3),
            Student(name = "Wildan Dzaky", ipk = "3.7", imageResId = R.drawable.ic_ava4)
        )
    }
}
