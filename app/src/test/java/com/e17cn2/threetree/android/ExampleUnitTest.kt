package com.e17cn2.threetree.android

import com.e17cn2.threetree.android.data.local.ConnectionDao
import com.e17cn2.threetree.android.data.remote.GameService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val connectionDao = ConnectionDao()
        val service = GameService(connectionDao)
        service.joinRoom(8090)
        GlobalScope.launch {
            service.getUsersInRoom()
        }
            service.voteStart(8090)
//        service.getUsersInRoom()
        service.getRoundResult()
    }
}