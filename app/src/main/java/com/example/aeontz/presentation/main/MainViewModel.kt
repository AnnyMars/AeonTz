package com.example.aeontz.presentation.main

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aeontz.data.remote.ApiRepository
import com.example.aeontz.data.remote.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val pref: SharedPreferences
): ViewModel() {

    private val _response = MutableLiveData<List<Response>>()
    val response: LiveData<List<Response>> get() = _response

    private val token = pref.getString("token", "")

    fun fetchData(){
        viewModelScope.launch(Dispatchers.IO) {
            _response.postValue(token?.let { repository.getPayments(it) })
        }
    }

}