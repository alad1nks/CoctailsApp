package com.example.coctailsapp.ui.addcocktail.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.coctailsapp.App
import com.example.coctailsapp.MainActivity
import com.example.coctailsapp.databinding.DialogFragmentAddIngredientBinding
import com.example.coctailsapp.ui.addcocktail.viewmodel.AddCocktailViewModel
import javax.inject.Inject

class AddIngredientDialogFragment : DialogFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<AddCocktailViewModel>({ activity as MainActivity }) { viewModelFactory }
    private var _binding: DialogFragmentAddIngredientBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.addIngredientComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogFragmentAddIngredientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            viewModel.addRecipe(binding.editText.text.toString())
            dismiss()
        }
        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
    }
}