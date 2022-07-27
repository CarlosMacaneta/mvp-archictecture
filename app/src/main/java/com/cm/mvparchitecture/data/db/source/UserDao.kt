package com.cm.mvparchitecture.data.db.source

import androidx.room.*
import com.cm.mvparchitecture.domain.model.User

@Dao
interface UserDao {

    @Insert
    fun create(user: User)

    @Query("SELECT * FROM user WHERE id =:id")
    fun getUserById(id: Int): User?

    @Query("SELECT * FROM user WHERE username =:username")
    fun getUserByUsername(username: String): User?

    @Query("SELECT * FROM user")
    fun getUsers(): List<User>

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}