package com.example.gameapp.data

import com.example.gameapp.Deal
import com.example.gameapp.TopGame
import com.example.gamesdk.GameApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object GameDataSource {
    val apiService = GameApiService()

    fun getDeals(): Observable<ArrayList<Deal>>? {
        return apiService.apiClient
            .getDealsObservable()
            .map{ listDeal ->
                val deals = listDeal.map { deal -> DealMapper.fromSdk(deal)}
                val arrayList = arrayListOf<Deal>()
                    arrayList.addAll(deals)
                    arrayList
            }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }


    fun getMostOwnedGames(): Observable<ArrayList<TopGame>>? {
        return apiService.apiClient
            .getTopRatedGamesObservable()
            .map{ listTopGame ->
                val topGames = listTopGame.mapIndexed { index, topGame ->
                    TopGameMapper.fromSdk(topGame, index+1)
                }
                val arrayList = arrayListOf<TopGame>()
                arrayList.addAll(topGames)
                arrayList
            }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun getTopRated(): Observable<ArrayList<TopGame>>? {
        return apiService.apiClient
            .getMostOwnedGamesObservable()
            .map{ listTopGame ->
                val topGames = listTopGame.mapIndexed() { index, topGame ->
                    TopGameMapper.fromSdk(topGame, index + 1)}
                val arrayList = arrayListOf<TopGame>()
                arrayList.addAll(topGames)
                arrayList
            }.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}