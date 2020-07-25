package com.example.gamesdk

import retrofit2.Call
import retrofit2.http.GET


interface RetrofitGameApi {

    @GET(Routes.GET_DEALS)
    fun getDeals(): Call<ArrayList<Deal>>

    @GET(Routes.GET_TOP_100_GAMES)
    fun getTopRatedGames(): Call<ArrayList<TopGame>>

    @GET(Routes.GET_MOST_OWNED_GAMES)
    fun getMostOwnedGames(): Call<ArrayList<TopGame>>

}