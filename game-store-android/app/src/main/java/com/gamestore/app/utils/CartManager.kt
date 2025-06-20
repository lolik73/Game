package com.gamestore.app.utils

import com.gamestore.app.models.CartItem

object CartManager {
    
    private val cartItems = mutableListOf<CartItem>()
    
    fun addToCart(cartItem: CartItem) {
        val existingItem = cartItems.find { 
            it.game.id == cartItem.game.id && 
            it.selectedPlatform == cartItem.selectedPlatform 
        }
        
        if (existingItem != null) {
            existingItem.quantity += cartItem.quantity
        } else {
            cartItems.add(cartItem)
        }
    }
    
    fun removeFromCart(gameId: Int) {
        cartItems.removeAll { it.game.id == gameId }
    }
    
    fun updateQuantity(gameId: Int, newQuantity: Int) {
        val item = cartItems.find { it.game.id == gameId }
        item?.let {
            if (newQuantity <= 0) {
                removeFromCart(gameId)
            } else {
                it.quantity = newQuantity
            }
        }
    }
    
    fun getCartItems(): List<CartItem> {
        return cartItems.toList()
    }
    
    fun getCartItemCount(): Int {
        return cartItems.sumOf { it.quantity }
    }
    
    fun getSubtotal(): Double {
        return cartItems.sumOf { it.game.price * it.quantity }
    }
    
    fun clearCart() {
        cartItems.clear()
    }
}