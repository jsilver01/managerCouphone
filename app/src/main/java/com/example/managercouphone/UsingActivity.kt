package com.example.managercouphone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.databinding.ActivityUsingBinding

class UsingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUsingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}