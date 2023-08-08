package com.example.coctailsapp.ui.cocktailinfo.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.coctailsapp.App
import com.example.coctailsapp.MainActivity
import com.example.coctailsapp.databinding.FragmentCocktailInfoBinding
import com.example.coctailsapp.ui.cocktailinfo.viewmodel.CocktailInfoViewModel
import javax.inject.Inject

class CocktailInfoFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<CocktailInfoViewModel>({ activity as MainActivity }) { viewModelFactory }
    private var _binding: FragmentCocktailInfoBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.cocktailInfoComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCocktailInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cocktail.observe(viewLifecycleOwner) {
            binding.name.text = it.title
            binding.description.text = it.description
        }
    }

}