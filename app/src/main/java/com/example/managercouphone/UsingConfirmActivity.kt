package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.databinding.ActivityUsingConfirmBinding

class UsingConfirmActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUsingConfirmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsingConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usingConfirmCorrect.setOnClickListener {
            val intent = Intent(this, UsingActivity::class.java)
            startActivity(intent)
        }

        binding.usingConfirmWrong.setOnClickListener {
            val intent = Intent(this, KeypadUsingActivity::class.java)
            startActivity(intent)
        }
    }
}