package com.e17cn2.threetree.entity

import java.io.Serializable

data class Room(
    val id: String,
    val minBet: Double,
    val rounds: List<Round>,
    val serverPort: Int
) : Serializable {
    companion object {
        val serialVersionUID = 1L
    }
}