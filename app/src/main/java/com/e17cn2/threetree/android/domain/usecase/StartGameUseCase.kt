package com.e17cn2.threetree.android.domain.usecase

import com.e17cn2.threetree.android.data.remote.GameService

class StartGameUseCase(private val gameService: GameService) {
    operator fun invoke(roomId: Int) = gameService.joinRoom(roomId)
}