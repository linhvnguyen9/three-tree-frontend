package com.e17cn2.threetree.android.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Connection(
    @SerializedName("ip_address") val idAddress: String,
    @SerializedName("room_id") val roomId: Int,
    @SerializedName("player_id") val playerId: String,
    val message: String
) : Serializable
