package com.example.ru_tube.data.remove

import com.example.ru_tube.BuildConfig
import com.example.ru_tube.model.PlayList
import com.example.ru_tube.utils.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    suspend fun getPLayList(
        @Query("part") part: String = Const.PART,
        @Query("channelId") channelId: String = Const.CHANNEL_ID,
        @Query("key") apiKey: String = BuildConfig.API_KEY,
        @Query("maxResults") maxResults: Int = Const.MAX_RESULT
    ): Response<PlayList>
}