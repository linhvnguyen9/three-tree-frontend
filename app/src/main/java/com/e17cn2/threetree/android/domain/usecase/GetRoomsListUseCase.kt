package com.e17cn2.threetree.android.domain.usecase

import com.e17cn2.threetree.android.data.remote.RoomsService
import com.e17cn2.threetree.entity.Room
import timber.log.Timber

class GetRoomsListUseCase (private val roomsService: RoomsService) {
    operator suspend fun invoke() : List<Room> {
        Timber.d("GetRoomsListUseCase()")
        val result = roomsService.getRoomsList().body()
        Timber.d("GetRoomsListUseCase() result $result")
        return result!!
    }
}