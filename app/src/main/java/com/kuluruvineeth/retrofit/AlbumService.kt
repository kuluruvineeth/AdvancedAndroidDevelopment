package com.kuluruvineeth.retrofit

import retrofit2.http.GET

interface AlbumService {
    @GET("/albums")
    suspend fun getAlbums() : Result<Album>
}