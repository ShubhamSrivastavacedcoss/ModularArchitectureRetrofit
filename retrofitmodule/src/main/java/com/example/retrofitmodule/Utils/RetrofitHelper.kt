package com.example.retrofitmodule.Utils


import com.example.modulararchitectureretrofit.Utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {


    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.INSTANCE.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}