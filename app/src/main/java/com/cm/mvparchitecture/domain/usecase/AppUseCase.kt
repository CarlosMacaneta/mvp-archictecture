package com.cm.mvparchitecture.domain.usecase

data class AppUseCase(
    val createUser: CreateUserUseCase,
    val getUserByUsername: GetUserByUsername
)
