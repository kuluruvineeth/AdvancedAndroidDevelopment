package com.kuluruvineeth.dependencyinjection

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmartPhone @Inject constructor(val battery: Battery,val simCard: SIMCard,val memoryCard: MemoryCard) {
    init {
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailability()
        Log.i("MYTAG","SmartPhone Constructed")
    }

    fun makeACallWithRecording(){
        Log.i("MYTAG","Calling......")
    }
}