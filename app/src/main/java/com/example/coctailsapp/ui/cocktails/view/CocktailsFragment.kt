package com.example.coctailsapp.ui.cocktails.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coctailsapp.App
import com.example.coctailsapp.MainActivity
import com.example.coctailsapp.R
import com.example.coctailsapp.databinding.FragmentCocktailsBinding
import com.example.coctailsapp.ui.cocktails.adapter.CocktailsAdapter
import com.example.coctailsapp.ui.cocktails.model.CocktailItem
import com.example.coctailsapp.ui.cocktails.viewmodel.CocktailsViewModel
import javax.inject.Inject

class CocktailsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<CocktailsViewModel>({ activity as MainActivity }) { viewModelFactory }
    private var _binding: FragmentCocktailsBinding? = null
    private val binding get() = _binding!!

    private val adapter = CocktailsAdapter(
        onItemClicked = { id ->
            val bundle = Bundle()
            bundle.putInt("id", id)
            this.findNavController().navigate(
                R.id.action_cocktail_to_CocktailInfoFragment,
                bundle
            )
        }
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.cocktailsComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCocktailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = GridLayoutManager(context, 2)
        viewModel.cocktailList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        viewModel.getCocktails()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}