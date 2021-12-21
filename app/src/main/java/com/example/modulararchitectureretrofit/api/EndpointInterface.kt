package com.example.modulararchitectureretrofit.api

import com.example.modulararchitectureretrofit.models.QuoteList
import com.example.modulararchitectureretrofit.newmodels.PageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EndpointInterface {

    @GET("/api/users")
    suspend fun getQuotes(@Query("page") page: Int): Response<PageResponse>
}
