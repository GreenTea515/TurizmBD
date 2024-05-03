package com.example.turizm20

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.asLiveData
import com.example.turizm20.BD2.Item
import com.example.turizm20.BD2.MainDB
import com.example.turizm20.databinding.ActivityKlimatBinding

class Klimat : AppCompatActivity() {
    lateinit var binding: ActivityKlimatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKlimatBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fun bacck1(view: View) {
            val but: ImageButton = findViewById(R.id.imageButton11)
            when (but?.id) {
                R.id.imageButton11 -> finish()
            }
        }

        val db = MainDB.getDB(this)
        db.getDao().getAllItem().asLiveData().observe(this){list->
            binding.textView32.text=""
            list.forEach{
                val text = "${it.name} t°      ${it.price} φ\n"
                binding.textView32.append(text)
            }
        }
        binding.button9.setOnClickListener {
            val item = Item(null,
                binding.editTextText5.text.toString(),
                binding.editTextText6.text.toString()
            )
            Thread{
                db.getDao().insertItem(item)
            }.start()
        }
    }
}