package com.example.turizm20

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.asLiveData
import com.example.turizm20.BD3.MainDatBas
import com.example.turizm20.BD3.predmet
import com.example.turizm20.databinding.ActivityDostoprimechBinding

class Dostoprimech : AppCompatActivity() {
    lateinit var binding: ActivityDostoprimechBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDostoprimechBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun bacck1(view: View) {
            val but: ImageButton = findViewById(R.id.nazad)
            when (but?.id) {
                R.id.nazad -> finish()
            }
        }

        val db = MainDatBas.getDaBa(this)
        db.getDaO().getAllpredmet().asLiveData().observe(this){list->
            binding.textlist1.text=""
            list.forEach{
                val text = "${it.name}      ${it.price}\n"
                binding.textlist1.append(text)
            }
        }
        binding.btn.setOnClickListener {
            val predmett = predmet(null,
                binding.edname.text.toString(),
                binding.edtext.text.toString()
            )
            Thread{
                db.getDaO().insertpredmet(predmett)
            }.start()
        }
    }
}