package com.example.gameapp.data

import com.example.gameapp.Deal

object DealMapper {

    fun fromSdk(deal: com.example.gamesdk.Deal) : Deal {
        return Deal(deal.title,
            deal.salePrice,
            deal.normalPrice,
            deal.metacriticScore,
            deal.steamRating,
            deal.thumb)
    }
}