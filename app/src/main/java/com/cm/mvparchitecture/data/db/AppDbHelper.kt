package com.cm.mvparchitecture.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cm.mvparchitecture.domain.model.User
import com.cm.mvparchitecture.data.db.source.UserDao

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class AppDbHelper: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME = "app_db"
    }
}