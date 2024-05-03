package com.example.turizm20

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }
    fun bbb1 (view: View){
        val bb1 : Button = findViewById(R.id.karta)
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun bbb2 (view: View){
        val bb1 : Button = findViewById(R.id.spravochnik)
        val intent: Intent = Intent(this, Spravochnik::class.java)
        startActivity(intent)
    }

}