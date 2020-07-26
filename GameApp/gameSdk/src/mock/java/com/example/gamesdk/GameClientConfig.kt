package com.example.gamesdk

import okhttp3.OkHttpClient
import retrofit2.Retrofit

class GameClientConfig : GameApiConfig {
    companion object {
        const val DEFAULT_RESPONSE = "{\"status\" : \"success\"}"
    }

    override fun setupConfig(buider: Retrofit.Builder) {
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(MockResponseInterceptor(getMockResponses(), DEFAULT_RESPONSE))
            .build()

        buider.client(client)
    }

    private fun getMockResponses(): HashMap<String, String> {
        return hashMapOf(
            Pair(Routes.GET_DEALS, MockResponses.DEALS_RESPONSE),
            Pair(Routes.GET_TOP_100_GAMES, MockResponses.TOP_100_GAMES),
            Pair(Routes.GET_MOST_OWNED_GAMES, MockResponses.TOP_100_GAMES)
        )
    }
}