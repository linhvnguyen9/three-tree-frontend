package com.e17cn2.threetree.android.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.e17cn2.threetree.android.data.remote.GameService
import com.e17cn2.threetree.entity.Connection
import java.io.Serializable

class GetUsersInRoomUseCase (private val gameService: GameService) {
    suspend operator fun invoke() : LiveData <List<Connection>> = gameService.getUsersInRoom()
}