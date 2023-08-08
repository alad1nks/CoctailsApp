package com.example.coctailsapp.ui.addcocktail.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coctailsapp.App
import com.example.coctailsapp.MainActivity
import com.example.coctailsapp.databinding.FragmentAddCocktailBinding
import com.example.coctailsapp.delegate.DelegateAdapter
import com.example.coctailsapp.delegate.DelegateAdapterItem
import com.example.coctailsapp.delegate.DelegatesAdapter
import com.example.coctailsapp.ui.addcocktail.adapter.ButtonPlusDelegateAdapter
import com.example.coctailsapp.ui.addcocktail.adapter.IngredientsDelegateAdapter
import com.example.coctailsapp.ui.addcocktail.viewmodel.AddCocktailViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddCocktailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<AddCocktailViewModel>({ activity as MainActivity }) { viewModelFactory }
    private var _binding: FragmentAddCocktailBinding? = null
    private val binding get() = _binding!!

    private val dialogFragment: AddIngredientDialogFragment = AddIngredientDialogFragment()

    private val adapter by lazy {
        DelegatesAdapter.Builder()
            .add(IngredientsDelegateAdapter(
                onClick = {

                }
            ) as DelegateAdapter<out DelegateAdapterItem, *>)
            .add(ButtonPlusDelegateAdapter(
                onClick = {
                    dialogFragment.show(parentFragmentManager, "sas")
                }
            ) as DelegateAdapter<out DelegateAdapterItem, *>)
            .build()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.addCocktailComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddCocktailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextTitle.setText(viewModel.title.value)
        binding.editTextDescription.setText(viewModel.description.value)
        binding.editTextRecipe.setText(viewModel.recipe.value)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        viewModel.delegateList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding.buttonSave.setOnClickListener {
            viewModel.addCocktail()
            viewModel.wipe()
            findNavController().popBackStack()
        }
        binding.buttonCancel.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.editTextTitle.addTextChangedListener {
            lifecycleScope.launch {
                it?.let { text -> viewModel.changeTitle(text.toString()) }
            }
        }

        binding.editTextDescription.addTextChangedListener {
            lifecycleScope.launch {
                it?.let { text -> viewModel.changeDescription(text.toString()) }
            }
        }

        binding.editTextRecipe.addTextChangedListener {
            lifecycleScope.launch {
                it?.let { text -> viewModel.changeRecipe(text.toString()) }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}