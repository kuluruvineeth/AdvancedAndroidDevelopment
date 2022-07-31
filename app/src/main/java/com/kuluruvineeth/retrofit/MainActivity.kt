package com.kuluruvineeth.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrService = RetrofitInstance.getRetrofitInstance()
            .create(AlbumService::class.java)
        val responseLiveData:LiveData<Response<Album>> = liveData {
            //val response = retrService.getAlbums()
            val response = retrService.getSortedAlbums(3)
            emit(response)
        }
        var textView = findViewById<TextView>(R.id.text_view)
        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if(albumsList!=null){
                while(albumsList.hasNext()){
                    val albumsItem = albumsList.next()
                    val result = ""+"Album Title : ${albumsItem.title}"+"\n"+
                            " "+"Album id : ${albumsItem.id}"+"\n"+
                            " "+"User id : ${albumsItem.userId}"+"\n\n\n"
                    textView.append(result)
                }
            }
        })
    }
}