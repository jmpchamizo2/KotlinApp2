package com.example.gamesdk.serializer

import com.example.gamesdk.TopGame
import com.google.gson.*
import java.lang.reflect.Type

class TopGameDeserializer : JsonDeserializer<TopGame> {

    companion object {
        const val BASE_IMG_URL = "http://cdn.akamai.steamstatic.com/steam/apps/%s/capsule_184x69.jpg"

    }


    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): TopGame {
        val gson = Gson()

        val topGame = gson.fromJson(json, TopGame::class.java)

        val jsonGame = json.asJsonObject
        val appId = jsonGame["appid"].asInt.toString()

        val rawRatting = jsonGame["score_rank"].asString
        val steamRating = if (rawRatting.isEmpty()) 0 else Integer.parseInt(rawRatting)


        val thumb = String.format(BASE_IMG_URL, appId)

        topGame.thumb = thumb
        topGame.steamRating = steamRating
        topGame.price /= 100
        return topGame
    }


}