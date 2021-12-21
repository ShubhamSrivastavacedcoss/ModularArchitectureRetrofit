package com.example.modulararchitectureretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.modulararchitectureretrofit.newmodels.PageResponse
import com.example.modulararchitectureretrofit.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(2)
        }
    }

    val quotes : LiveData<PageResponse>
    get() = repository.quotes
}