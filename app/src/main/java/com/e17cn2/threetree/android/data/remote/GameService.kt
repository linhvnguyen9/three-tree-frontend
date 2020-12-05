package com.e17cn2.threetree.android.data.remote

import com.e17cn2.threetree.entity.Connection
import com.e17cn2.threetree.android.data.local.ConnectionDao
import com.e17cn2.threetree.entity.Player
import com.e17cn2.threetree.entity.PlayerStatus
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
        socket = Socket("192.168.1.133", roomId)

        oos = ObjectOutputStream(socket.getOutputStream())
        ois = ObjectInputStream(socket.getInputStream())

        oos.writeObject(
            Connection(
                clientIp,
                roomId,
                "5fcb9a0e6d0e7a0e9eff936c",
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
            "5fcb9a0e6d0e7a0e9eff936c",
            "READY"
        )
        println(voteStart)
        oos.writeObject(voteStart)
        println("Vote start done")
    }

    fun getRoundResult(): Round {
        val result = ois.readObject()
        val round = result as? Round

        while (round != null) {
            val connection = result as List<Connection>
            println(connection)
        }
        println("Wait for card result")
        val roundResult = ois.readObject() as Round
        println(roundResult)
        Timber.d("round result $roundResult")
        return roundResult
    }

    fun getUsersInRoom() {
        val result = ois.readObject() as List<Connection>
        println(result)
    }

    fun closeConnection() {
        ois.close()
        oos.close()
        socket.close()
    }
}
