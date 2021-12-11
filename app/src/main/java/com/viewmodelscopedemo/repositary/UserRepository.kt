package com.viewmodelscopedemo.repositary

import com.viewmodelscopedemo.model.User
import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUser(): List<User> {
        delay(8000)

        val users: List<User> = listOf(
            User(1, "Sam"),
            User(2, "Ram"),
            User(3, "Cham"),
            User(4, "Kam")
        )
        return users
    }

}
