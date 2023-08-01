package com.example.managercouphone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class KeypadActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 버튼 클릭 이벤트 리스너 등록
        buttonClick.setOnClickListener {
            // 클릭 시 텍스트를 변경합니다.
            textViewResult.text = "버튼이 클릭되었습니다!"
        }
    }
} {
}