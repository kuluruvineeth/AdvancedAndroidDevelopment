package com.kuluruvineeth.dependencyinjection

import android.util.Log

class ServiceProvider {
    init {
        Log.i("MYTAG","Servie Provider Constructed")
    }

    fun getServiceProvider(){
        Log.i("MYTAG","Service provider connected")
    }
}