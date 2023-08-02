package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.databinding.ActivitySavingBinding

class SavingActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySavingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}