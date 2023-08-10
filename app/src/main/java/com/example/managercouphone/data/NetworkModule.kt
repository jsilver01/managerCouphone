package com.example.managercouphone.data

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL2 = "https://couphone.shop/"

fun okHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return builder.addInterceptor(logging).build()
}

fun getRetrofit(): Retrofit {
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL2)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient())
        .build()

    return retrofit
}
var user_token : String = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZW1iZXIyM0BleGFtcGxlLmNvbSIsImF1dGgiOiJST0xFX0FETUlOIiwidXNlcklkIjoiMTQiLCJpYXQiOjE2OTE2NDMwMzAsImV4cCI6MTY5MjI0NzgzMH0.BBLma3sAzdcM18p3qBaOgzANr42Gn_0BKsDTlqDzZEE"