package com.e17cn2.threetree.android.data.remote

import com.e17cn2.threetree.entity.Connection
import com.e17cn2.threetree.android.data.local.ConnectionDao
import com.e17cn2.threetree.entity.Round
import timber.log.Timber
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.Socket

class GameService(private val connectionDao: ConnectionDao) {
    private lateinit var socket: Socket
    private lateinit var ois: ObjectInputStream
    private lateinit var oos: ObjectOutputStream

    private val clientIp = connectionDao.getClientIpAddress()

    fun joinRoom(roomId: Int): Connection {
        socket = Socket("10.170.77.8", roomId)

        oos = ObjectOutputStream(socket.getOutputStream())
        ois = ObjectInputStream(socket.getInputStream())

        oos.writeObject(
            Connection(
                clientIp,
                roomId,
                "5fc66d052fc9055ddc0d3485",
                "JOIN"
            )
        )
        val response = ois.readObject() as Connection
        Timber.d(response.toString())
        println("Response $response")
        return response
    }

    fun voteStart(roomId: Int) {
        println("Voting to start")
        val voteStart =  Connection(
            clientIp,
            roomId,
            "22",
            "READY"
        )
        println(voteStart)
        oos.writeObject(voteStart)
        println("Vote start done")
    }

    fun getRoundResult(): Round {
        println("Wait for card result")
        val roundResult = ois.readObject() as Round
        println(roundResult)
        Timber.d("round result $roundResult")
        return roundResult
    }

    fun closeConnection() {
        ois.close()
        oos.close()
        socket.close()
    }
}
