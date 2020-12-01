package com.e17cn2.threetree.android.presentation.di

import com.e17cn2.threetree.android.domain.usecase.GetClientIpAddressUseCase
import com.e17cn2.threetree.android.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MainViewModel(get()) }
    factory { GetClientIpAddressUseCase(get()) }
}