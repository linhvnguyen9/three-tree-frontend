package com.e17cn2.threetree.android.data.remote

import com.e17cn2.threetree.android.data.local.ConnectionDao
import com.e17cn2.threetree.android.domain.model.Connection
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.Socket

class GameService(private val connectionDao: ConnectionDao) {
    private lateinit var socket: Socket
    private lateinit var ois: ObjectInputStream
    private lateinit var oos: ObjectOutputStream

    fun joinRoom() : Connection {
        val roomId = 8090 //TODO: Remove hardcode
        val clientIp = connectionDao.getClientIpAddress()
        socket = Socket("27.79.233.101", roomId)

        oos = ObjectOutputStream(socket.getOutputStream())
        ois = ObjectInputStream(socket.getInputStream())

        oos.writeObject(Connection(clientIp, roomId, "22", ""))
        val response = ois.readObject() as Connection
        Timber.d(response.toString())
        return response
    }

    fun voteReady() {

    }




}
