package com.example.modulararchitectureretrofit.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.modulararchitectureretrofit.api.EndpointInterface

import com.example.modulararchitectureretrofit.newmodels.PageResponse


class QuoteRepository(private val quoteApi: EndpointInterface) {


    var quoteMutableData= MutableLiveData<PageResponse>()

    val quotes: LiveData<PageResponse>
    get() = quoteMutableData

    suspend fun getQuotes(page: Int){
        val result= quoteApi.getQuotes(page)

        if (result?.body() != null){
            quoteMutableData.postValue(result.body())
        }

    }


}