package com.example.coctailsapp.ui.addcocktail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coctailsapp.databinding.HolderPlusIngredientBinding
import com.example.coctailsapp.delegate.DelegateAdapter
import com.example.coctailsapp.ui.addcocktail.model.ButtonPlusItem

class ButtonPlusDelegateAdapter(
    private val onClick: () -> Unit
) : DelegateAdapter<ButtonPlusItem, ButtonPlusDelegateAdapter.ButtonPlusViewHolder>(ButtonPlusItem::class.java) {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HolderPlusIngredientBinding.inflate(inflater, parent, false)
        return ButtonPlusViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ButtonPlusViewHolder, item: ButtonPlusItem) {
        holder.itemView.setOnClickListener {
            onClick()
        }

    }

    class ButtonPlusViewHolder(
        private val binding: HolderPlusIngredientBinding
    ) : RecyclerView.ViewHolder(binding.root)
}