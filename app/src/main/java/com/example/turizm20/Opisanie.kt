package com.example.turizm20

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.turizm20.DB.AppDatabase
import com.example.turizm20.DB.Student
import com.example.turizm20.databinding.ActivityOpisanieBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Opisanie : AppCompatActivity() {

    private lateinit var binding : ActivityOpisanieBinding
    private lateinit var appDb : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpisanieBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        val name = binding.editTextText.text.toString()
        val opisanie = binding.editTextText2.text.toString()
        val rollNo = binding.editTextText3.text.toString()

        if (name.isNotEmpty() && opisanie.isNotEmpty() && rollNo.isNotEmpty()){

            GlobalScope.launch(Dispatchers.IO){
                appDb.studentDao().update(name, opisanie,rollNo.toInt())
            }
            binding.editTextText.text.clear()
            binding.editTextText2.text.clear()
            binding.editTextText3.text.clear()
            Toast.makeText(this@Opisanie,"Запись изменина", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@Opisanie,"Введите все данные", Toast.LENGTH_SHORT).show()
        }
    }

    private fun writeData(){

        val name = binding.editTextText.text.toString()
        val opisanie = binding.editTextText2.text.toString()
        val rollNo = binding.editTextText3.text.toString()

        if (name.isNotEmpty() && opisanie.isNotEmpty() && rollNo.isNotEmpty()){
            val student = Student(
                null,name,opisanie,rollNo.toInt()
            )
            GlobalScope.launch(Dispatchers.IO){
                appDb.studentDao().insert(student)
            }
            binding.editTextText.text.clear()
            binding.editTextText2.text.clear()
            binding.editTextText3.text.clear()
            Toast.makeText(this@Opisanie,"Запись добавлена", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@Opisanie,"Введите все данные", Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun displayData(student: Student){
        withContext(Dispatchers.Main){
            binding.t1.text = student.name.toString()
            binding.t2.text= student.opisanie.toString()
            binding.t3.text= student.rollNo.toString()

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

