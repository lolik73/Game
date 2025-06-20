package com.gamestore.app.data

import com.gamestore.app.models.Game
import com.gamestore.app.models.GameCategory
import com.gamestore.app.models.Platform

object GameRepository {
    
    fun getAllGames(): List<Game> {
        return listOf(
            Game(
                id = 1,
                title = "Cyberpunk 2077",
                description = "Откройте для себя мир будущего в этой захватывающей RPG с открытым миром",
                price = 2999.0,
                originalPrice = 3999.0,
                imageUrl = "cyberpunk_2077",
                category = GameCategory.RPG,
                genre = "Action RPG",
                rating = 4.2f,
                platform = listOf(Platform.PC, Platform.PLAYSTATION, Platform.XBOX),
                releaseDate = "2020",
                developer = "CD Projekt RED",
                isOnSale = true,
                discountPercent = 25
            ),
            Game(
                id = 2,
                title = "The Witcher 3",
                description = "Эпическое фэнтези приключение в роли ведьмака Геральта",
                price = 1499.0,
                imageUrl = "witcher_3",
                category = GameCategory.RPG,
                genre = "Action RPG",
                rating = 4.8f,
                platform = listOf(Platform.PC, Platform.PLAYSTATION, Platform.XBOX, Platform.NINTENDO_SWITCH),
                releaseDate = "2015",
                developer = "CD Projekt RED"
            ),
            Game(
                id = 3,
                title = "Call of Duty: MW3",
                description = "Новейший шутер от первого лица с захватывающим мультиплеером",
                price = 4999.0,
                imageUrl = "cod_mw3",
                category = GameCategory.NEW_RELEASES,
                genre = "FPS",
                rating = 4.5f,
                platform = listOf(Platform.PC, Platform.PLAYSTATION, Platform.XBOX),
                releaseDate = "2023",
                developer = "Infinity Ward"
            ),
            Game(
                id = 4,
                title = "Baldur's Gate 3",
                description = "Классическая RPG с пошаговыми боями и глубоким сюжетом",
                price = 3499.0,
                imageUrl = "baldurs_gate_3",
                category = GameCategory.RPG,
                genre = "Turn-based RPG",
                rating = 4.9f,
                platform = listOf(Platform.PC, Platform.PLAYSTATION),
                releaseDate = "2023",
                developer = "Larian Studios"
            ),
            Game(
                id = 5,
                title = "Hades",
                description = "Инди-игра в жанре roguelike с потрясающим геймплеем",
                price = 999.0,
                originalPrice = 1499.0,
                imageUrl = "hades",
                category = GameCategory.INDIE,
                genre = "Roguelike",
                rating = 4.7f,
                platform = listOf(Platform.PC, Platform.PLAYSTATION, Platform.XBOX, Platform.NINTENDO_SWITCH),
                releaseDate = "2020",
                developer = "Supergiant Games",
                isOnSale = true,
                discountPercent = 33
            ),
            Game(
                id = 6,
                title = "Age of Empires IV",
                description = "Стратегическая игра в реальном времени с историческими цивилизациями",
                price = 2799.0,
                imageUrl = "age_of_empires_4",
                category = GameCategory.STRATEGY,
                genre = "RTS",
                rating = 4.3f,
                platform = listOf(Platform.PC, Platform.XBOX),
                releaseDate = "2021",
                developer = "Relic Entertainment"
            ),
            Game(
                id = 7,
                title = "Spider-Man Remastered",
                description = "Станьте Человеком-пауком в этом захватывающем экшене",
                price = 2299.0,
                originalPrice = 3299.0,
                imageUrl = "spiderman",
                category = GameCategory.ACTION,
                genre = "Action Adventure",
                rating = 4.6f,
                platform = listOf(Platform.PC, Platform.PLAYSTATION),
                releaseDate = "2022",
                developer = "Insomniac Games",
                isOnSale = true,
                discountPercent = 30
            ),
            Game(
                id = 8,
                title = "Hollow Knight",
                description = "Атмосферный метроидвания с прекрасной рисованной графикой",
                price = 699.0,
                imageUrl = "hollow_knight",
                category = GameCategory.INDIE,
                genre = "Metroidvania",
                rating = 4.8f,
                platform = listOf(Platform.PC, Platform.PLAYSTATION, Platform.XBOX, Platform.NINTENDO_SWITCH),
                releaseDate = "2017",
                developer = "Team Cherry"
            )
        )
    }
    
    fun getGamesByCategory(category: GameCategory): List<Game> {
        return getAllGames().filter { it.category == category }
    }
    
    fun getGameById(id: Int): Game? {
        return getAllGames().find { it.id == id }
    }
    
    fun searchGames(query: String): List<Game> {
        return getAllGames().filter { 
            it.title.contains(query, ignoreCase = true) ||
            it.genre.contains(query, ignoreCase = true) ||
            it.developer.contains(query, ignoreCase = true)
        }
    }
    
    fun getFeaturedGames(): List<Game> {
        return getAllGames().filter { it.rating >= 4.5f }.take(4)
    }
    
    fun getSaleGames(): List<Game> {
        return getAllGames().filter { it.isOnSale }
    }
}