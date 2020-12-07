package com.e17cn2.threetree.android.domain.usecase

import com.e17cn2.threetree.android.data.remote.AccountService
import com.e17cn2.threetree.entity.LoginRequest

class LoginUseCase (private val accountService: AccountService) {
    suspend operator fun invoke(loginRequest: LoginRequest) = accountService.login(loginRequest)
}