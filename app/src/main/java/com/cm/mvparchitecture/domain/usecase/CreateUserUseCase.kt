package com.cm.mvparchitecture.domain.usecase

import com.cm.mvparchitecture.domain.model.User
import com.cm.mvparchitecture.domain.repository.UserRepository

class CreateUserUseCase(
    private val repository: UserRepository
) {
    operator fun invoke(user: User) = repository.create(user)
}