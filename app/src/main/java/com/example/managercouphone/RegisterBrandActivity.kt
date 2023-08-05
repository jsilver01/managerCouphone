package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.managercouphone.databinding.ActivityRegisterBrandBinding

class RegisterBrandActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBrandBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBrandBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goStoreBtn.setOnClickListener {
            val intent = Intent(this, RegisterStoreActivity::class.java)
            startActivity(intent)
        }

        binding.brandLogoBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            activityResult.launch(intent)
        }

        binding.backBtn.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private val activityResult : ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){

        if(it.resultCode == RESULT_OK && it.data != null){
            val uri = it.data!!.data

            Glide.with(this)
                .load(uri)
                .into(binding.brandLogoImage)
        }

    }
}