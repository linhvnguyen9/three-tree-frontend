package com.e17cn2.threetree.android.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e17cn2.threetree.android.domain.usecase.LoginUseCase
import com.e17cn2.threetree.entity.LoginRequest
import com.e17cn2.threetree.entity.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val loginUseCase: LoginUseCase): ViewModel() {
    val response = MutableLiveData<Response<Player>>()

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            response.value = loginUseCase(loginRequest)
        }
    }
}