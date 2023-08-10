package com.example.managercouphone.data

import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @GET("/users")
    fun getUserInfo(
        @Header("Authorization") token: String
    ): Call<UserInfoResponse>

    @POST("/coupons")
    fun postCoupons(
        @Header("Authorization") token: String,
        @Body coupon: Coupon
    ): Call<CouponResponse>

    @PATCH("/coupons/status/{coupon-id}")
    fun getCouponUseResponse(
        @Header("Authorization") token: String,
        @Path("coupon-id") couponId: Int
    ): Call<CouponUseResponse>

    @PATCH("/coupons/stamp/{coupon-id}")
    fun getCouponGetResponse(
        @Header("Authorization") token: String,
        @Path("coupon-id") couponId: Int,
    ): Call<CouponGetResponse>


    @PATCH("/users/form")
    fun patchUserInfo(
        @Header("Authorization") token: String,
        @Body  userForm:UserForm,
    ) :Call<UserFormResult>
}