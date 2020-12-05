package com.e17cn2.threetree.entity

import java.io.Serializable

data class Player(
    val id: String,
    val username: String,
    val password: String,
    val money: Double,
    val status: PlayerStatus
) : Serializable {
    companion object {
        val serialVersionUID = 1L
    }
}