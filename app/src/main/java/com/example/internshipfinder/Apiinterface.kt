package com.example.internshipfinder

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {

    @GET("8b6e4cbe-bf78-4cb4-a8ff-ccba5772cbe0")
    fun getdata(): Call<List<InternshipModel>>
}

//https://mocki.io/v1/8b6e4cbe-bf78-4cb4-a8ff-ccba5772cbe0