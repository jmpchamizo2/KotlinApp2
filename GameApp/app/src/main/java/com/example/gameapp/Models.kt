package com.example.gameapp

object PriceFormatter {
    val FORMAT_PRICE = "$ %.2f"

    fun priceFormatter(price: Float) = String.format(FORMAT_PRICE, price)
}

data class Deal(var title: String,
                var salePrice: Float,
                var normalPrice:Float,
                var metacriticScore: Int,
                var steamRating: Int,
                var thumb: String) {

    val salePriceFormatted : String
        get() = PriceFormatter.priceFormatter(salePrice)

    val normalPriceFormatted: String
        get() = PriceFormatter.priceFormatter(normalPrice)

}



data class TopGame(var title: String,
                   var owners: Int,
                   var steamRating: Int,
                   var publisher: String,
                   var price: Float,
                   var posititon: Int,
                   var thumb: String){

    val PriceFormatted : String
        get() = PriceFormatter.priceFormatter(price)

}