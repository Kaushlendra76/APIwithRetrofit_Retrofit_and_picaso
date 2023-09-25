package com.example.apiwithretrofit

import Apidata
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("products")
    fun getProductData() : Call<Apidata>
}