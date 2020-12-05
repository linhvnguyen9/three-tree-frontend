package com.e17cn2.threetree.android

import com.e17cn2.threetree.android.data.local.ConnectionDao
import com.e17cn2.threetree.android.data.remote.GameService
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class OtherUnitTest {
    @Test
    fun addition_isCorrect() {
        val connectionDao = ConnectionDao()
        val service = GameService(connectionDao)
        service.joinRoom()
        service.voteStart()
        service.getCards()
    }
}