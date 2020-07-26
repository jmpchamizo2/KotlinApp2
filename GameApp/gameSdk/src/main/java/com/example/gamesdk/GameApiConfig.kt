package com.example.gamesdk

import retrofit2.Retrofit

interface GameApiConfig {

    fun setupConfig(buider: Retrofit.Builder)
}