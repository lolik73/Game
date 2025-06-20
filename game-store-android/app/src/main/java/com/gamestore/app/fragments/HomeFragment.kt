package com.gamestore.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gamestore.app.adapters.GameAdapter
import com.gamestore.app.data.GameRepository
import com.gamestore.app.databinding.FragmentHomeBinding
import com.gamestore.app.models.GameCategory

class HomeFragment : Fragment() {
    
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var gameAdapter: GameAdapter
    private var currentCategory = GameCategory.NEW_RELEASES
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupCategoryTabs()
        loadGames()
    }
    
    private fun setupRecyclerView() {
        gameAdapter = GameAdapter { game ->
            // Navigate to game detail
            val fragment = ProductDetailFragment.newInstance(game.id)
            parentFragmentManager.beginTransaction()
                .replace(android.R.id.content, fragment)
                .addToBackStack(null)
                .commit()
        }
        
        binding.recyclerViewGames.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = gameAdapter
        }
    }
    
    private fun setupCategoryTabs() {
        binding.chipNewReleases.setOnClickListener {
            selectCategory(GameCategory.NEW_RELEASES)
        }
        
        binding.chipAction.setOnClickListener {
            selectCategory(GameCategory.ACTION)
        }
        
        binding.chipRpg.setOnClickListener {
            selectCategory(GameCategory.RPG)
        }
        
        binding.chipStrategy.setOnClickListener {
            selectCategory(GameCategory.STRATEGY)
        }
        
        binding.chipIndie.setOnClickListener {
            selectCategory(GameCategory.INDIE)
        }
        
        binding.chipSale.setOnClickListener {
            selectCategory(GameCategory.SALE)
        }
    }
    
    private fun selectCategory(category: GameCategory) {
        currentCategory = category
        
        // Reset all chips
        binding.chipNewReleases.isChecked = false
        binding.chipAction.isChecked = false
        binding.chipRpg.isChecked = false
        binding.chipStrategy.isChecked = false
        binding.chipIndie.isChecked = false
        binding.chipSale.isChecked = false
        
        // Select current chip
        when (category) {
            GameCategory.NEW_RELEASES -> binding.chipNewReleases.isChecked = true
            GameCategory.ACTION -> binding.chipAction.isChecked = true
            GameCategory.RPG -> binding.chipRpg.isChecked = true
            GameCategory.STRATEGY -> binding.chipStrategy.isChecked = true
            GameCategory.INDIE -> binding.chipIndie.isChecked = true
            GameCategory.SALE -> binding.chipSale.isChecked = true
        }
        
        loadGames()
    }
    
    private fun loadGames() {
        val games = if (currentCategory == GameCategory.SALE) {
            GameRepository.getSaleGames()
        } else {
            GameRepository.getGamesByCategory(currentCategory).ifEmpty {
                GameRepository.getFeaturedGames()
            }
        }
        gameAdapter.submitList(games)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}