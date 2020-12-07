package com.e17cn2.threetree.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Player(
    val id: String,
    val username: String,
    val password: String,
    val money: Double,
    @SerializedName("playerStatus") val status: PlayerStatus
) : Serializable {
    companion object {
        val serialVersionUID = 1L
    }
}