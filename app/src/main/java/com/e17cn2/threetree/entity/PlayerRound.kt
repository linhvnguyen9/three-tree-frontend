package com.e17cn2.threetree.entity

import com.e17cn2.threetree.entity.Card
import com.e17cn2.threetree.entity.Player
import java.io.Serializable

data class PlayerRound(val player: Player, val card1: Card, val card2: Card, val card3: Card) :
    Serializable {
    companion object {
        val serialVersionUID = 2L
    }
}
