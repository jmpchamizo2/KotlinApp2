package com.example.gameapp.data

import com.example.gameapp.TopGame

object TopGameMapper {

    fun fromSdk(topGame: com.example.gamesdk.TopGame, position: Int) : TopGame{
        return TopGame(topGame.title,
        topGame.owners,
        topGame.steamRating,
        topGame.publisher,
        topGame.price,
        position,
        topGame.thumb)
    }
}