package com.e17cn2.threetree.android.data.repository

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.e17cn2.threetree.android.data.local.ConnectionDao
import com.e17cn2.threetree.android.domain.repository.ConnectionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ConnectionRepositoryImpl(private val connectionDao: ConnectionDao) : ConnectionRepository {
    @MainThread
    override suspend fun getClientLocalIp() : String {
        return connectionDao.getClientIpAddress()
    }
}