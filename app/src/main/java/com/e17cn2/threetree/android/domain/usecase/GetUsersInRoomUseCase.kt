package com.e17cn2.threetree.android.domain.usecase

import com.e17cn2.threetree.android.data.remote.GameService
import java.io.Serializable

class GetUsersInRoomUseCase (private val gameService: GameService) {
    suspend operator fun invoke() = gameService.getUsersInRoom()
}