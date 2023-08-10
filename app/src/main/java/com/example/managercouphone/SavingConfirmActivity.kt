package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.data.ApiInterface
import com.example.managercouphone.data.CouponGetResponse
import com.example.managercouphone.data.getRetrofit
import com.example.managercouphone.data.user_token
import com.example.managercouphone.databinding.ActivitySavingConfirmBinding
import retrofit2.Call
import retrofit2.Response

class SavingConfirmActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySavingConfirmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavingConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.savingConfirmCorrect.setOnClickListener {
            val intent = Intent(this, SavingActivity::class.java)
            startActivity(intent)
            val service =  getRetrofit().create(ApiInterface::class.java)
            Log.d("token", "Bearer $user_token")
            service.getCouponGetResponse("Bearer $user_token", couponId = 14)
                .enqueue( object : retrofit2.Callback<CouponGetResponse>{
                    override fun onResponse(
                        call: Call<CouponGetResponse>,
                        response: Response<CouponGetResponse>
                    ) {
                        if(response.isSuccessful) {
                            val resp = response.body()

                            Log.d("CouponGetResponse", resp.toString())
                        }
                        else{
                            Log.d("CouponGetResponse", response.toString())
                        }
                    }

                    override fun onFailure(call: Call<CouponGetResponse>, t: Throwable) {
                        Log.d("CouponGetResponse",t.message.toString())
                    }

                })
        }

        binding.savingConfirmWrong.setOnClickListener {
            val intent = Intent(this, KeypadActivity::class.java)
            startActivity(intent)
        }
    }
}