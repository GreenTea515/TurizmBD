package com.example.turizm20

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.turizm20.DB.AppDatabase
import com.example.turizm20.DB.Student
import com.example.turizm20.databinding.ActivityInformaciaBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Informacia : AppCompatActivity() {
    private lateinit var binding : ActivityInformaciaBinding
    private lateinit var appDb : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformaciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun backk2(view: View) {
            val but: ImageButton = findViewById(R.id.imageButton2)
            when (but?.id) {
                R.id.imageButton2 -> finish()
            }
        }

        appDb = AppDatabase.getDatabase(this)

        binding.save.setOnClickListener {
            writeData()
        }

        binding.read.setOnClickListener {
            readData()
        }

        binding.delete.setOnClickListener{
            GlobalScope.launch{
                appDb.studentDao().deleteAll()
            }
        }
        binding.button11.setOnClickListener {
            updateData()
        }

    }
    private fun updateData(){

        val firstName = binding.editTextText.text.toString()
        val lastName = binding.editTextText2.text.toString()
        val rollNo = binding.editTextText3.text.toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && rollNo.isNotEmpty()){

            GlobalScope.launch(Dispatchers.IO){
                appDb.studentDao().update(firstName,lastName,rollNo.toInt())
            }
            binding.editTextText.text.clear()
            binding.editTextText2.text.clear()
            binding.editTextText3.text.clear()
            Toast.makeText(this@Informacia,"Запись изменина", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@Informacia,"Введите все данные", Toast.LENGTH_SHORT).show()
        }
    }

    private fun writeData(){

        val firstName = binding.editTextText.text.toString()
        val lastName = binding.editTextText2.text.toString()
        val rollNo = binding.editTextText3.text.toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && rollNo.isNotEmpty()){
            val student = Student(
                null,firstName,lastName,rollNo.toInt()
            )
            GlobalScope.launch(Dispatchers.IO){
                appDb.studentDao().insert(student)
            }
            binding.editTextText.text.clear()
            binding.editTextText2.text.clear()
            binding.editTextText3.text.clear()
            Toast.makeText(this@Informacia,"Запись добавлена", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@Informacia,"Введите все данные", Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun displayData(student: Student){
        withContext(Dispatchers.Main){
            binding.textView25.text = student.name.toString()
            binding.textView29.text= student.opisanie.toString()
            binding.textView30.text= student.rollNo.toString()

        }
    }

    private  fun readData() {
        val rollNo = binding.editTextText4.text.toString()
        if (rollNo.isNotEmpty()) {
            lateinit var student: Student
            GlobalScope.launch {
                student = appDb.studentDao().findByRoll(rollNo.toInt())
                displayData(student)
            }
        }
    }
}