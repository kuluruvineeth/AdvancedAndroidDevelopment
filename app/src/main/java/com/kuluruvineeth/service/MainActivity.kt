package com.kuluruvineeth.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kuluruvineeth.service.MyBackgroundService.Companion.MARKS
import com.kuluruvineeth.service.MyBackgroundService.Companion.NAME
import com.kuluruvineeth.service.MyBackgroundService.Companion.TAG
import com.kuluruvineeth.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val serviceIntent = Intent(this,MyBackgroundService::class.java)
        serviceIntent.putExtra(NAME,"Vineeth")
        serviceIntent.putExtra(MARKS,100)
        binding.btnStart.setOnClickListener {
            Log.i(TAG,"Started service")
            startService(serviceIntent)
        }

        binding.btnStop.setOnClickListener {
            Log.i(TAG,"Stopping service")
            stopService(serviceIntent)
        }
    }
}