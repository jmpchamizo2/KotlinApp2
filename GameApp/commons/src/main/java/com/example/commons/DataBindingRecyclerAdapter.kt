package com.example.commons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingRecyclerAdapter<MODEL> (val itemVariableId: Int, private val itemLayoutResId: Int): RecyclerView.Adapter<DataBindingViewholder<MODEL>>() {

    val items: MutableList<MODEL> = mutableListOf()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingViewholder<MODEL> {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                                    itemLayoutResId,
                                    parent,
                                 false)
        return DataBindingViewholder(itemVariableId, binding)
    }

    override fun onBindViewHolder(holder: DataBindingViewholder<MODEL>, position: Int) {
        holder.bindItem(items[position])
    }


}