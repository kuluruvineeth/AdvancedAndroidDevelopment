package com.kuluruvineeth.viewmodelscope.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers() : List<User>{
        delay(8000)
        val users : List<User> = listOf(
            User(1,"Vineeth"),
            User(2,"Kuluru"),
            User(3,"Agririze"),
            User(4,"Google")
        )
        return users
    }
}