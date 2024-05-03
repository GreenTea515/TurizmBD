package com.example.turizm20.Goroda

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.turizm20.R

class sevastopol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sevastopol)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
    fun bb8 (view: View) {
        val b: Button = findViewById(R.id.button4)
        when (b.id) {
            R.id.button4 -> finish()
        }
    }
}