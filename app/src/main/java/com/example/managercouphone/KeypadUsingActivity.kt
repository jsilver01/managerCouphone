package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.databinding.ActivityKeypadBinding
import com.example.managercouphone.databinding.ActivityKeypadUsingBinding

class KeypadUsingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityKeypadUsingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeypadUsingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val et_num = binding.numbersEt

        binding.btnZero.setOnClickListener {
            appendNumber(et_num, "0")
        }

        binding.btnOne.setOnClickListener {
            appendNumber(et_num, "1")
        }

        binding.btnTwo.setOnClickListener {
            appendNumber(et_num, "2")
        }

        binding.btnThree.setOnClickListener {
            appendNumber(et_num, "3")
        }

        binding.btnFour.setOnClickListener {
            appendNumber(et_num, "4")
        }

        binding.btnFive.setOnClickListener {
            appendNumber(et_num, "5")
        }

        binding.btnSix.setOnClickListener {
            appendNumber(et_num, "6")
        }

        binding.btnSeven.setOnClickListener {
            appendNumber(et_num, "7")
        }

        binding.btnEight.setOnClickListener {
            appendNumber(et_num, "8")
        }

        binding.btnNine.setOnClickListener {
            appendNumber(et_num, "9")
        }

        binding.btnDelete.setOnClickListener {
            if (et_num.text.isNotEmpty()) {
                et_num.text = et_num.text.delete(et_num.text.length - 1, et_num.text.length)
            }
        }

        binding.btnOkay.setOnClickListener {
            val intent = Intent(this, KeypadPinActivity::class.java)
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