package com.e17cn2.threetree.android.domain.repository

import androidx.lifecycle.LiveData

interface ConnectionRepository {
    suspend fun getClientLocalIp() : String
}