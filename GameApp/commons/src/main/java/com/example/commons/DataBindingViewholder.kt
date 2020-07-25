package com.example.commons

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingViewholder<MODEL>(val itemVaraibleId: Int, val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){

    fun bindItem(item: MODEL) {
        binding.setVariable(itemVaraibleId, item)
        binding.executePendingBindings()
    }
}