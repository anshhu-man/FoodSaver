package com.example.foodsaver

import com.example.adiva.db.user
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type: application/json")
    @POST("/v1/user/create")
    fun createUser( @Header("Authorization") auth:String, @Body requestBody: RequestBody ): Call<user>

    @Headers("Content-Type: application/json")
    @POST("/v1/user/profile/get")
    fun getUser( @Header("Authorization") auth:String, @Body requestBody: RequestBody ): Call<user>
}