package com.example.turizm20

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Spravochnik : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spravochnik)
    }
    fun opisanie (view: View){
        val bb1 : ImageView = findViewById(R.id.im1)
        val intent: Intent = Intent(this, Opisanie::class.java)
        startActivity(intent)
    }
    fun inform (view: View){
        val bb1 : ImageView = findViewById(R.id.im2)
        val intent: Intent = Intent(this, Informacia::class.java)
        startActivity(intent)
    }
    fun dostoprim (view: View){
        val bb1 : ImageView = findViewById(R.id.im3)
        val intent: Intent = Intent(this, Dostoprimech::class.java)
        startActivity(intent)
    }
    fun klimat (view: View){
        val bb1 : ImageView = findViewById(R.id.im4)
        val intent: Intent = Intent(this, Klimat::class.java)
        startActivity(intent)
    }
    fun back2(view: View) {
        val but: ImageButton = findViewById(R.id.imageButton)
        when (but?.id) {
            R.id.imageButton -> finish()
        }
    }
}