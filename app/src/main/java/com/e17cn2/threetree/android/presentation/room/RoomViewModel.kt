package com.e17cn2.threetree.android.presentation.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e17cn2.threetree.android.domain.usecase.QuitGameUseCase
import com.e17cn2.threetree.android.domain.usecase.StartGameUseCase
import com.e17cn2.threetree.android.domain.usecase.VoteStartUseCase
import com.e17cn2.threetree.entity.PlayerRound
import com.e17cn2.threetree.entity.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(private val startGameUseCase: StartGameUseCase, private val quitGameUseCase: QuitGameUseCase, private val voteStartUseCase: VoteStartUseCase) : ViewModel() {
    private lateinit var room: Room

    private val _playerRounds = MutableLiveData<List<PlayerRound>>()
    val playerRounds : LiveData<List<PlayerRound>> get() = _playerRounds

    fun setRoom(room: Room) {
        this.room = room
    }

    fun quitGame() {
        viewModelScope.launch {
            quitGameUseCase()
        }
    }

    fun voteStart() {
        viewModelScope.launch(Dispatchers.IO) {
            startGameUseCase(room.serverPort)
            val result = voteStartUseCase(room.serverPort)
            _playerRounds.postValue(result.playerRoundList)
        }
    }
}