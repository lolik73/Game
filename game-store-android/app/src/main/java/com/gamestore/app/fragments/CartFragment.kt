package com.gamestore.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gamestore.app.adapters.CartAdapter
import com.gamestore.app.databinding.FragmentCartBinding
import com.gamestore.app.utils.CartManager

class CartFragment : Fragment() {
    
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var cartAdapter: CartAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupCheckoutButton()
        updateCartUI()
    }
    
    private fun setupRecyclerView() {
        cartAdapter = CartAdapter(
            onQuantityChanged = { cartItem, newQuantity ->
                CartManager.updateQuantity(cartItem.game.id, newQuantity)
                updateCartUI()
            },
            onRemoveItem = { cartItem ->
                CartManager.removeFromCart(cartItem.game.id)
                updateCartUI()
            }
        )
        
        binding.recyclerViewCart.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cartAdapter
        }
    }
    
    private fun setupCheckoutButton() {
        binding.buttonCheckout.setOnClickListener {
            if (CartManager.getCartItems().isNotEmpty()) {
                Toast.makeText(requireContext(), "Заказ оформлен! Спасибо за покупку!", Toast.LENGTH_LONG).show()
                CartManager.clearCart()
                updateCartUI()
            } else {
                Toast.makeText(requireContext(), "Корзина пуста", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun updateCartUI() {
        val cartItems = CartManager.getCartItems()
        
        if (cartItems.isEmpty()) {
            binding.layoutEmptyCart.visibility = View.VISIBLE
            binding.layoutCartContent.visibility = View.GONE
        } else {
            binding.layoutEmptyCart.visibility = View.GONE
            binding.layoutCartContent.visibility = View.VISIBLE
            
            cartAdapter.submitList(cartItems)
            
            val subtotal = CartManager.getSubtotal()
            val deliveryFee = 299.0
            val total = subtotal + deliveryFee
            
            binding.textSubtotal.text = "${subtotal.toInt()} ₽"
            binding.textDeliveryFee.text = "${deliveryFee.toInt()} ₽"
            binding.textTotal.text = "${total.toInt()} ₽"
        }
    }
    
    override fun onResume() {
        super.onResume()
        updateCartUI()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}