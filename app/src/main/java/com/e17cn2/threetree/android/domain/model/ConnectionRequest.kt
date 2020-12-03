package com.e17cn2.threetree.android.domain.model

import com.google.gson.annotations.SerializedName

data class ConnectionRequest(
    @SerializedName("player_id") val playerId: Int
) {
}