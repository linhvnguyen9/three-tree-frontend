package com.e17cn2.threetree.android.domain.usecase

import com.e17cn2.threetree.android.data.remote.GameService

class QuitGameUseCase(private val gameService: GameService) {
    suspend operator fun invoke() = gameService.closeConnection()
}