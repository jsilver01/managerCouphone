package com.example.managercouphone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.managercouphone.data.ApiInterface
import com.example.managercouphone.data.CouponGetResponse
import com.example.managercouphone.data.CouponUseResponse
import com.example.managercouphone.data.getRetrofit
import com.example.managercouphone.data.user_token
import com.example.managercouphone.databinding.ActivityUsingConfirmBinding
import retrofit2.Call
import retrofit2.Response

class UsingConfirmActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUsingConfirmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsingConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usingConfirmCorrect.setOnClickListener {
            val intent = Intent(this, UsingActivity::class.java)
            startActivity(intent)

            val service =  getRetrofit().create(ApiInterface::class.java)
            Log.d("token", "Bearer $user_token")
            service.getCouponUseResponse("Bearer $user_token", couponId = 14)
                .enqueue( object : retrofit2.Callback<CouponUseResponse>{
                    override fun onResponse(
                        call: retrofit2.Call<CouponUseResponse>,
                        response: retrofit2.Response<CouponUseResponse>
                    ) {
                        if(response.isSuccessful) {
                            val resp = response.body()
                            Log.d("CouponUseResponse", resp.toString())
                        }
                        else{
                            Log.d("CouponUseResponse", response.toString())
                        }
                    }
                    override fun onFailure(call: retrofit2.Call<CouponUseResponse>, t: Throwable) {
                        Log.d("CouponUseResponse",t.message.toString())
                    }
                })

        }

        binding.usingConfirmWrong.setOnClickListener {
            val intent = Intent(this, KeypadPinActivity::class.java)
            startActivity(intent)
        }
    }
}