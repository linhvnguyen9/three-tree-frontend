package com.e17cn2.threetree.android.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.e17cn2.threetree.entity.Connection
import com.e17cn2.threetree.android.data.local.ConnectionDao
import com.e17cn2.threetree.entity.Player
import com.e17cn2.threetree.entity.PlayerStatus
import com.e17cn2.threetree.entity.Round
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.Socket

class GameService(private val connectionDao: ConnectionDao) {
    private lateinit var socket: Socket
    private lateinit var eventSocket : Socket
    private lateinit var ois: ObjectInputStream
    private lateinit var oos: ObjectOutputStream
    private lateinit var eventInputStream : ObjectInputStream
    private lateinit var eventOutputStream : ObjectOutputStream

    private val clientIp = connectionDao.getClientIpAddress()

    fun joinRoom(roomId: Int): List<Connection> {
        socket = Socket("192.168.1.133", roomId)
        println("Connected to main socket")
        eventSocket = Socket("192.168.1.133", roomId + 1)
        println("Connected to event socket")

        val playerId = connectionDao.getUserId()

        oos = ObjectOutputStream(socket.getOutputStream())
        println("OOS main socket")
        ois = ObjectInputStream(socket.getInputStream())
        println("OIS main socket")
        eventOutputStream = ObjectOutputStream(eventSocket.getOutputStream())
        println("OOS event socket")
        eventInputStream = ObjectInputStream(eventSocket.getInputStream())
        println("OIS event socket")

        oos.writeObject(
            Connection(
                clientIp,
                roomId,
                playerId,
                "JOIN"
            )
        )
        println("Write join msg success")
        ///////////////////////////////////
//        val response = ois.readObject() as List<Connection>
        val response = emptyList<Connection>()
        Timber.d(response.toString())
        println("Response $response")
        return response
    }

    fun voteStart(roomId: Int) {
        val playerId = connectionDao.getUserId()

        println("Voting to start")
//        val connections = eventInputStream.readObject() as List<Connection>
//        println("Before vote start sent connections $connections")
        val voteStart =  Connection(
            clientIp,
            roomId,
            playerId,
            "READY"
        )
        println(voteStart)
        eventOutputStream.writeObject(voteStart)
        println("Vote start done")
    }

    fun getRoundResult(): Round {
        println("Starting to get round result")
        val result = eventInputStream.readObject()
        val round = result as? Round

        while (round == null) {
            val connection = result as List<Connection>
            println(connection)
        }
        println("Wait for card result")
        println(round)
        Timber.d("round result $round")
        return round
    }

    suspend fun getUsersInRoom() : LiveData<List<Connection>> {
        Timber.d("Get users in room")
        val liveData = MutableLiveData<List<Connection>>()
        withContext(Dispatchers.IO) {
            while (true) {
                println("Listening for new connections")
                Timber.d("Listening for new connections")
                val connections = ois.readObject() as List<Connection>
                println("Number of players in room changes $connections")
                Timber.d("Number of players in room changes $connections")
                liveData.postValue(connections)
            }
        }
        return liveData
    }

    fun closeConnection() {
        ois.close()
        oos.close()
        socket.close()
    }
}
