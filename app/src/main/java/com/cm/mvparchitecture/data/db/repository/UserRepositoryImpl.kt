package com.cm.mvparchitecture.data.db.repository

import com.cm.mvparchitecture.data.db.source.UserDao
import com.cm.mvparchitecture.domain.model.User
import com.cm.mvparchitecture.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl
@Inject constructor(
    private val userDao: UserDao
): UserRepository {
    override fun create(user: User) = userDao.create(user)

    override fun getUserByUsername(username: String) = userDao.getUserByUsername(username)

    override fun getUserById(id: Int) = userDao.getUserById(id)

    override fun getUsers() = userDao.getUsers()

    override fun update(user: User) = userDao.update(user)

    override fun delete(user: User) = userDao.delete(user)
}