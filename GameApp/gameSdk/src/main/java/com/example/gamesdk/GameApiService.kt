package com.example.gamesdk

import com.example.gamesdk.serializer.ListTopGameDeserializer
import com.example.gamesdk.serializer.TopGameDeserializer
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameApiService(val apiConfig : GameApiConfig = GameClientConfig()) {

    val apiClient: RetrofitGameApi

    init {
        val tokenType = object : TypeToken<ArrayList<TopGame>>(){}.type

        val gson = GsonBuilder()
            .registerTypeAdapter(TopGame::class.java, TopGameDeserializer)
            .registerTypeAdapter(tokenType, ListTopGameDeserializer())
            .create()

        val apiClientConfig =
            Retrofit.Builder()
            .baseUrl(Routes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        apiConfig.setupConfig(apiClientConfig)

        apiClient = apiClientConfig.build().create(RetrofitGameApi::class.java )

    }
}