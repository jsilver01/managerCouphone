package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.data.ApiClient
import com.example.managercouphone.data.ApiInterface
import com.example.managercouphone.data.CouponGetResponse
import com.example.managercouphone.data.CouponGetResult
import com.example.managercouphone.data.UserResponse
import com.example.managercouphone.data.getRetrofit
import com.example.managercouphone.data.user_token
import com.example.managercouphone.databinding.ActivityKeypadBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KeypadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKeypadBinding
    private val apiService = ApiClient().apiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeypadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etNum = binding.numbersEt

        binding.btnZero.setOnClickListener {
            appendNumber(etNum, "0")
        }

        binding.btnOne.setOnClickListener {
            appendNumber(etNum, "1")
        }

        binding.btnTwo.setOnClickListener {
            appendNumber(etNum, "2")
        }

        binding.btnThree.setOnClickListener {
            appendNumber(etNum, "3")
        }

        binding.btnFour.setOnClickListener {
            appendNumber(etNum, "4")
        }

        binding.btnFive.setOnClickListener {
            appendNumber(etNum, "5")
        }

        binding.btnSix.setOnClickListener {
            appendNumber(etNum, "6")
        }

        binding.btnSeven.setOnClickListener {
            appendNumber(etNum, "7")
        }

        binding.btnEight.setOnClickListener {
            appendNumber(etNum, "8")
        }

        binding.btnNine.setOnClickListener {
            appendNumber(etNum, "9")
        }

        binding.btnDelete.setOnClickListener {
            if (etNum.text.isNotEmpty()) {
                etNum.text = etNum.text.delete(etNum.text.length - 1, etNum.text.length)
            }
        }

        binding.btnOkay.setOnClickListener {
            val phoneNumber = etNum.text.toString().replace("[^\\d]".toRegex(), "")
            val intent = Intent(this, SavingConfirmActivity::class.java)
            startActivity(intent)
        }
    }

    private fun appendNumber(editText: EditText, number: String) {
        if (editText.text.toString() == "전화번호  입력") {
            editText.setText(number)
        } else {
            editText.append(number)
        }

        val phoneNumber = editText.text.toString().replace("[^\\d]".toRegex(), "")
        val formattedPhoneNumber = buildFormattedPhoneNumber(phoneNumber)
        editText.setText(formattedPhoneNumber)
        editText.setSelection(formattedPhoneNumber.length)
    }

    private fun buildFormattedPhoneNumber(phoneNumber: String): String {
        val formattedNumber = StringBuilder()
        if (phoneNumber.length >= 3) {
            formattedNumber.append(phoneNumber.substring(0, 3))
            if (phoneNumber.length >= 7) {
                formattedNumber.append("-")
                formattedNumber.append(phoneNumber.substring(3, 7))
                if (phoneNumber.length >= 11) {
                    formattedNumber.append("-")
                    formattedNumber.append(phoneNumber.substring(7, 11))
                } else {
                    formattedNumber.append(phoneNumber.substring(7))
                }
            } else {
                formattedNumber.append(phoneNumber.substring(3))
            }
        } else {
            formattedNumber.append(phoneNumber)
        }
        return formattedNumber.toString()
    }


}
