package com.example.coctailsapp.ui.addcocktail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coctailsapp.databinding.HolderIngredientBinding
import com.example.coctailsapp.delegate.DelegateAdapter
import com.example.coctailsapp.ui.addcocktail.model.IngredientItem

class IngredientsDelegateAdapter(
    private val onClick: (Int) -> Unit
) : DelegateAdapter<IngredientItem, IngredientsDelegateAdapter.IngredientsViewHolder>(IngredientItem::class.java) {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HolderIngredientBinding.inflate(inflater, parent, false)
        return IngredientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, item: IngredientItem) {
        holder.bind(item)
//        holder.itemView.setOnClickListener {
//            item.onClick()
//        }
    }

    class IngredientsViewHolder(
        private val binding: HolderIngredientBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: IngredientItem) {
            binding.name.text = item.name

        }
    }

}