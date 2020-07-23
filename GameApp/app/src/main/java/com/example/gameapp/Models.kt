package com.example.gameapp

data class Deal(var title: String,
                var salePrice: Float,
                var normalPrice:Float,
                var metacriticScore: Int,
                var steamRating: Int,
                var thumb: String)



data class TopGAme(var title: String,
                    var owners: Int,
                    var steamRating: Int,
                    var publisher: String,
                    var price: Float,
                    var posititon: Int,
                    var thumb: String)