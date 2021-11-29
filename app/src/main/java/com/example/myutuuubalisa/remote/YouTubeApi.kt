package com.example.myutuuubalisa.remote

import com.example.myutuuubalisa.model.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {

    @GET("playlists")
    fun getPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,

        ): Call<PlayList>

    @GET("playlistItem")
    fun getPlaylistItems(
        @Query("part") part: String,
        @Query("key") apiKey: String,
        @Query("id") id: String,

        ): Call<PlayList>
}