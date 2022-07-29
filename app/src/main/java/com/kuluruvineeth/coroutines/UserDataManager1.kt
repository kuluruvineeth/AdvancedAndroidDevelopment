package com.kuluruvineeth.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager1 {

    suspend fun getTotalUserCount() : Int {
        var count=0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        }
        return count
    }
}