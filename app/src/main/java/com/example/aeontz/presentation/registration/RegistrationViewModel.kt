package com.example.aeontz.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aeontz.data.remote.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: ApiRepository
): ViewModel() {

    fun makePost(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.makePost("demo", "12345")
        }
    }

}