package com.e17cn2.threetree.android.domain.usecase

import com.e17cn2.threetree.android.data.remote.GameService
import com.e17cn2.threetree.entity.Round

class VoteStartUseCase(private val gameService: GameService) {
    operator fun invoke(roomId: Int) : Round {
        gameService.voteStart(roomId)
        val result = gameService.getRoundResult()
        return result
    }
}