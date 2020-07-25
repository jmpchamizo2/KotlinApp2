package com.example.gamesdk

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameApiService {

    val apiClient: RetrofitGameApi

    init {
        val apiClientConfig =
            Retrofit.Builder()
            .baseUrl(Routes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiClient = apiClientConfig.create(RetrofitGameApi::class.java )

    }
}