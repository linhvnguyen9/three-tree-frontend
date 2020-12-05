package com.e17cn2.threetree.entity

import com.e17cn2.threetree.entity.Player
import java.io.Serializable

data class Round(val playerRoundList: List<PlayerRound>, val winner: Player): Serializable {
    companion object {
        val serialVersionUID = 2L
    }
}