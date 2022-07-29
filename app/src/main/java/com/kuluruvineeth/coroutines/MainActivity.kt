package com.kuluruvineeth.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var count=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnCount = findViewById<Button>(R.id.btnCount)
        val btnDownloadUserData = findViewById<Button>(R.id.btnDownloadUserData)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            downloadUserData()
        }
    }
    private fun downloadUserData(){
        for(i in 1..200000){
            Log.i("MyTag","Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}