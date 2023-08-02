package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.databinding.ActivitySavingConfirmBinding

class SavingConfirmActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySavingConfirmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavingConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.savingConfirmCorrect.setOnClickListener {
            val intent = Intent(this, SavingActivity::class.java)
            startActivity(intent)
        }

        binding.savingConfirmWrong.setOnClickListener {
            val intent = Intent(this, KeypadActivity::class.java)
            startActivity(intent)
        }
    }
}