package com.e17cn2.threetree.android.domain.model

data class Room(
    val id: Int,
    val minBet: Double,
    val rounds: List<Round>,
    val serverPort: Int
) {
}