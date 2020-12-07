package com.e17cn2.threetree.android.presentation.room

import androidx.lifecycle.*
import com.e17cn2.threetree.android.domain.usecase.GetUsersInRoomUseCase
import com.e17cn2.threetree.android.domain.usecase.QuitGameUseCase
import com.e17cn2.threetree.android.domain.usecase.StartGameUseCase
import com.e17cn2.threetree.android.domain.usecase.VoteStartUseCase
import com.e17cn2.threetree.entity.Connection
import com.e17cn2.threetree.entity.PlayerRound
import com.e17cn2.threetree.entity.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class RoomViewModel(private val startGameUseCase: StartGameUseCase, private val quitGameUseCase: QuitGameUseCase, private val voteStartUseCase: VoteStartUseCase, private val getUsersInRoomUseCase: GetUsersInRoomUseCase) : ViewModel() {
    private lateinit var room: Room

    private val _playerRounds = MutableLiveData<List<PlayerRound>>()
    val playerRounds : LiveData<List<PlayerRound>> get() = _playerRounds

    private val _userSource = MediatorLiveData<List<Connection>>()
    val usersInRoom : LiveData<List<Connection>> get() = _userSource
    private var userSource : LiveData<List<Connection>> = MutableLiveData()

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage : LiveData<String> get() = _toastMessage

    private val _winnerText = MutableLiveData<String>()
    val winnerText : LiveData<String> get() = _winnerText

    val observer = Observer<List<Connection>> {
        Timber.d(it.toString())
    }

    init {
        usersInRoom.observeForever(observer)
    }

    fun setRoom(room: Room) {
        this.room = room
        viewModelScope.launch(Dispatchers.Main) {
            _userSource.removeSource(userSource)
            withContext(Dispatchers.IO) {
                startGameUseCase(room.serverPort)
                _toastMessage.postValue("Connected to room ${room.serverPort} successfully")
                userSource = getUsersInRoomUseCase()
            }
            try {
                _userSource.addSource(userSource) {
                    _userSource.value = it
                }
            } catch (e: IllegalArgumentException) {
                Timber.e(e)
            }
        }
    }

    fun quitGame() {
        viewModelScope.launch {
            quitGameUseCase()
        }
    }

    fun voteStart() {
        viewModelScope.launch(Dispatchers.IO) {
            _toastMessage.postValue("Vote start")
            val result = voteStartUseCase(room.serverPort)
            Timber.d("Return card result in VM $result")
            Timber.d("Return card result in VM ${result.playerRoundList}")
            _playerRounds.postValue(result.playerRoundList)
            _toastMessage.postValue("Round completed")
            _winnerText.postValue("Winner = ${result.playerRoundList.find { it.player.id == result.winner.id }?.player?.username}")
        }
    }
}