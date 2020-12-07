package com.e17cn2.threetree.android.data.remote

import com.e17cn2.threetree.entity.LoginRequest
import com.e17cn2.threetree.entity.Player
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountService {
    @POST("api/players/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<Player>
}