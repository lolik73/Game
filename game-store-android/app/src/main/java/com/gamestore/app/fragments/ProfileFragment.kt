package com.gamestore.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gamestore.app.databinding.FragmentProfileBinding
import com.gamestore.app.models.User

class ProfileFragment : Fragment() {
    
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupUserProfile()
        setupSupportButton()
    }
    
    private fun setupUserProfile() {
        // Mock user data
        val user = User(
            id = "GS_001337",
            username = "ProGamer2024",
            email = "progamer@gamestore.com",
            registrationDate = "15 января 2024",
            deliveryAddress = "г. Москва, ул. Геймерская, д. 42, кв. 1337"
        )
        
        binding.apply {
            textUsername.text = user.username
            textUserId.text = "ID: ${user.id}"
            textEmail.text = user.email
            textRegistrationDate.text = "Дата регистрации: ${user.registrationDate}"
            textDeliveryAddress.text = user.deliveryAddress
        }
    }
    
    private fun setupSupportButton() {
        binding.buttonSupport.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Служба поддержки: support@gamestore.com\nТелефон: +7 (800) 555-GAME",
                Toast.LENGTH_LONG
            ).show()
        }
        
        binding.buttonEditProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Редактирование профиля", Toast.LENGTH_SHORT).show()
        }
        
        binding.buttonOrderHistory.setOnClickListener {
            Toast.makeText(requireContext(), "История заказов", Toast.LENGTH_SHORT).show()
        }
        
        binding.buttonSettings.setOnClickListener {
            Toast.makeText(requireContext(), "Настройки", Toast.LENGTH_SHORT).show()
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}