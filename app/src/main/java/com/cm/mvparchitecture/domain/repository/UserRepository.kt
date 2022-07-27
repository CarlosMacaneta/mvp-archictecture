package com.cm.mvparchitecture.domain.repository

import com.cm.mvparchitecture.domain.model.User

interface UserRepository {

    fun create(user: User)

    fun getUserByUsername(username: String): User?

    fun getUserById(id: Int): User?

    fun getUsers(): List<User>

    fun update(user: User)

    fun delete(user: User)
}