package com.gamestore.app.models

data class Game(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val originalPrice: Double? = null,
    val imageUrl: String,
    val category: GameCategory,
    val genre: String,
    val rating: Float,
    val platform: List<Platform>,
    val releaseDate: String,
    val developer: String,
    val isOnSale: Boolean = false,
    val discountPercent: Int = 0
)

enum class GameCategory {
    NEW_RELEASES,
    ACTION,
    RPG,
    STRATEGY,
    INDIE,
    SALE
}

enum class Platform {
    PC,
    PLAYSTATION,
    XBOX,
    NINTENDO_SWITCH,
    MOBILE
}

data class CartItem(
    val game: Game,
    var quantity: Int = 1,
    val selectedPlatform: Platform
)

data class User(
    val id: String,
    val username: String,
    val email: String,
    val registrationDate: String,
    val deliveryAddress: String,
    val avatarUrl: String? = null
)