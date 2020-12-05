package com.e17cn2.threetree.android.data.remote

import com.e17cn2.threetree.entity.Room
import retrofit2.Response
import retrofit2.http.GET

interface RoomsService {
    @GET("api/rooms")
    suspend fun getRoomsList() : Response<List<Room>>
}