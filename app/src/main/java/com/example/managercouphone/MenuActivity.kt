package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menuSavingButton.setOnClickListener {
            val intent = Intent(this, KeypadActivity::class.java)
            startActivity(intent)
        }

        binding.menuUsingButton.setOnClickListener {
            val intent = Intent(this, KeypadUsingActivity::class.java)
            startActivity(intent)
        }
    }
}