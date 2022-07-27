package com.cm.mvparchitecture.domain.usecase

import com.cm.mvparchitecture.domain.model.User
import com.cm.mvparchitecture.domain.repository.UserRepository

class GetUserByUsername(
    private val repository: UserRepository
) {
    operator fun invoke(email: String): User? =
        repository.getUserByUsername(email)
}