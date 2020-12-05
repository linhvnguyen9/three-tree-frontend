package com.e17cn2.threetree.entity

import com.google.gson.annotations.SerializedName

data class ConnectionRequest(
    @SerializedName("player_id") val playerId: Int
) {
    companion object {
        val serialVersionUID = 1L
    }
}