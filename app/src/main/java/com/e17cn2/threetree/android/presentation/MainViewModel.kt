package com.e17cn2.threetree.android.presentation

import androidx.lifecycle.*
import com.e17cn2.threetree.android.domain.usecase.GetClientIpAddressUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(private val getClientIpAddressUseCase: GetClientIpAddressUseCase) : ViewModel() {
    val clientIp = liveData {
        emit(getClientIpAddressUseCase())
    }
}