package com.e17cn2.threetree.android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.e17cn2.threetree.android.domain.usecase.GetClientIpAddressUseCase

class MainViewModel(private val getClientIpAddressUseCase: GetClientIpAddressUseCase) : ViewModel() {
    val clientIp: LiveData<String> = liveData {
        emitSource(getClientIpAddressUseCase())
    }
}