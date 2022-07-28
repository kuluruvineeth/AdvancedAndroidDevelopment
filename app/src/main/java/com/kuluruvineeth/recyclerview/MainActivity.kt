package com.kuluruvineeth.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val fruitsList = listOf<Fruit>(
        Fruit("Mango","Vineeth"),
        Fruit("Apple","Kuluru"),
        Fruit("Banana","Sri"),
        Fruit("Pineapple","Siri"),
        Fruit("Orange","Alexa"),
        Fruit("Pomegranate","Hey Google"),
        Fruit("Guava","Android"),
        Fruit("Grapes","Google Cloud")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitsList)
    }
}