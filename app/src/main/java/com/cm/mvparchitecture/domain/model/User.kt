package com.cm.mvparchitecture.domain.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index(
            value = ["username"],
            unique = true
        )
    ]
)
data class User(
    val username: String?,
    val password: String?,
    @PrimaryKey val id: Int? = null,
)
