package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.databinding.ActivityKeypadUsingBinding

class KeypadUsingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityKeypadUsingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeypadUsingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tv_num = binding.numbersTv

        binding.btnZero.setOnClickListener {
            if(tv_num.text == "전화번호 입력"){
                tv_num.text = "${binding.btnZero.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnZero.text}"
            }
        }

        binding.btnOne.setOnClickListener {
            if(tv_num.text=="전화번호 입력"){
                tv_num.text = "${binding.btnOne.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnOne.text}"
            }
        }

        binding.btnTwo.setOnClickListener {
            if(tv_num.text == "전화번호 입력"){
                tv_num.text = "${binding.btnTwo.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnTwo.text}"
            }
        }

        binding.btnThree.setOnClickListener {
            if(tv_num.text == "전화번호 입력"){
                tv_num.text = "${binding.btnThree.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnThree.text}"
            }
        }

        binding.btnFour.setOnClickListener {
            if(tv_num.text == "전화번호 입력"){
                tv_num.text = "${binding.btnFour.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnFour.text}"
            }
        }

        binding.btnFive.setOnClickListener {
            if(tv_num.text == "전화번호 입력"){
                tv_num.text = "${binding.btnFive.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnFive.text}"
            }
        }

        binding.btnSix.setOnClickListener {
            if(tv_num.text == "전화번호 입력"){
                tv_num.text = "${binding.btnSix.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnSix.text}"
            }
        }

        binding.btnSeven.setOnClickListener {
            if(tv_num.text == "전화번호 입력"){
                tv_num.text = "${binding.btnSeven.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnSeven.text}"
            }
        }

        binding.btnEight.setOnClickListener {
            if(tv_num.text == "전화번호 입력"){
                tv_num.text = "${binding.btnEight.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnEight.text}"
            }
        }

        binding.btnNine.setOnClickListener {
            if(tv_num.text == "전화번호 입력"){
                tv_num.text = "${binding.btnNine.text}"
            } else {
                tv_num.text = "${tv_num.text}${binding.btnNine.text}"
            }
        }

        binding.btnDelete.setOnClickListener {
            if (!tv_num.text.isEmpty()){
                tv_num.text = tv_num.text.substring(0, tv_num.text.length - 1)
            }
        }

        binding.btnOkay.setOnClickListener {
            val intent = Intent(this, UsingConfirmActivity::class.java)
            startActivity(intent)
        }
    }
}