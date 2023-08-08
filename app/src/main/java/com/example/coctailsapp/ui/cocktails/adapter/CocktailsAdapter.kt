package com.example.coctailsapp.ui.cocktails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coctailsapp.databinding.HolderCocktailBinding
import com.example.coctailsapp.ui.cocktails.model.CocktailItem

class CocktailsAdapter(
    private val onItemClicked: (Int) -> Unit
) : ListAdapter<CocktailItem, CocktailsAdapter.FilmCardsViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmCardsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HolderCocktailBinding.inflate(inflater, parent, false)
        return FilmCardsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmCardsViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(item.id)
        }
        holder.bind(item)
    }


    class FilmCardsViewHolder(
        private val binding: HolderCocktailBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CocktailItem) {
//            binding.image.setImageBitmap(item.image)
            binding.title.text = item.title
        }
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<CocktailItem>() {
        override fun areItemsTheSame(oldItem: CocktailItem, newItem: CocktailItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CocktailItem, newItem: CocktailItem): Boolean {
            return oldItem == newItem
        }

    }
}