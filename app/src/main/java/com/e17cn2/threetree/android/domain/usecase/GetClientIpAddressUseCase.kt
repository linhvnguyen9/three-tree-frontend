package com.e17cn2.threetree.android.domain.usecase

import com.e17cn2.threetree.android.domain.repository.ConnectionRepository

class GetClientIpAddressUseCase(private val repository: ConnectionRepository) {
    suspend operator fun invoke() = repository.getClientLocalIp()
}