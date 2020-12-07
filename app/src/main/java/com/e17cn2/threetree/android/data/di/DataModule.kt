package com.e17cn2.threetree.android.data.di

import com.e17cn2.threetree.android.data.local.ConnectionDao
import com.e17cn2.threetree.android.data.remote.AccountService
import com.e17cn2.threetree.android.data.remote.GameService
import com.e17cn2.threetree.android.data.remote.RoomsService
import com.e17cn2.threetree.android.data.repository.ConnectionRepositoryImpl
import com.e17cn2.threetree.android.domain.repository.ConnectionRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    factory { ConnectionDao() }
    factory<ConnectionRepository> { ConnectionRepositoryImpl(get()) as ConnectionRepository }

    factory {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.1.86:8088")
            .build()
    }

    factory { get<Retrofit>().create(RoomsService::class.java) }
    factory { get<Retrofit>().create(AccountService::class.java) }
    single { GameService(get()) }
}