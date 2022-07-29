package com.kuluruvineeth.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count=0
    private lateinit var tvUserMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnCount = findViewById<Button>(R.id.btnCount)
        val btnDownloadUserData = findViewById<Button>(R.id.btnDownloadUserData)
        tvUserMessage = findViewById<TextView>(R.id.tvUserMessage)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {

            //defines coroutines scope and builds
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }*/
        /*CoroutineScope(Dispatchers.IO).launch{
            Log.i("MyTag","Calculation started....")
            val stock1 = async{getStock()}
            val stock2 = async{getStock1()}
            val total = stock1.await()+stock2.await()
            Log.i("MyTag","Total is $total")
        }*/
        //other way
        CoroutineScope(Dispatchers.Main).launch{
            Log.i("MyTag","Calculation started....")
            val stock1 = async(Dispatchers.IO){getStock()}
            val stock2 = async(Dispatchers.IO){getStock1()}
            val total = stock1.await()+stock2.await()
            Toast.makeText(applicationContext,"Total is $total",Toast.LENGTH_SHORT).show()
            Log.i("MyTag","Total is $total")
        }
    }
    private suspend fun downloadUserData(){
        for(i in 1..200000){
            withContext(Dispatchers.Main){
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
            }

        }
    }

    private suspend fun getStock() : Int {
        delay(10000)
        Log.i("MyTag","stock 1 returned")
        return 55000
    }

    private suspend fun getStock1() : Int {
        delay(8000)
        Log.i("MyTag","stock 2 returned")
        return 35000
    }
}