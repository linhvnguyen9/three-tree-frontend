package com.e17cn2.threetree.android.presentation.di

import com.e17cn2.threetree.android.domain.usecase.*
import com.e17cn2.threetree.android.presentation.MainViewModel
import com.e17cn2.threetree.android.presentation.room.RoomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { RoomViewModel(get(), get(), get(), get()) }

    factory { GetClientIpAddressUseCase(get()) }
    factory { GetRoomsListUseCase(get()) }
    factory { StartGameUseCase(get()) }
    factory { QuitGameUseCase(get()) }
    factory { VoteStartUseCase(get()) }
    factory { GetUsersInRoomUseCase(get()) }
}