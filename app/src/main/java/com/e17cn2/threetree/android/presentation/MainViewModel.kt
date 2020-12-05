package com.e17cn2.threetree.android.presentation

import androidx.lifecycle.*
import com.e17cn2.threetree.android.domain.usecase.GetClientIpAddressUseCase
import com.e17cn2.threetree.android.domain.usecase.GetRoomsListUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(private val getClientIpAddressUseCase: GetClientIpAddressUseCase, private val getRoomsListUseCase: GetRoomsListUseCase) : ViewModel() {
    val clientIp = liveData {
        emit(getClientIpAddressUseCase())
    }

    val rooms = liveData {
        emit(getRoomsListUseCase())
    }
}