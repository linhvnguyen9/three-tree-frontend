package com.e17cn2.threetree.android.data.di

import com.e17cn2.threetree.android.data.local.ConnectionDao
import com.e17cn2.threetree.android.data.repository.ConnectionRepositoryImpl
import com.e17cn2.threetree.android.domain.repository.ConnectionRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    factory { ConnectionDao() }
    factory<ConnectionRepository> { ConnectionRepositoryImpl(get()) as ConnectionRepository }
}