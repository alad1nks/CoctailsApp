package com.example.coctailsapp.ui.addcocktail.model

import com.example.coctailsapp.delegate.DelegateAdapterItem

data class ButtonPlusItem(
    val id: Int = -1
) : DelegateAdapterItem {
    override fun id() = id

    override fun content() = id

}