package com.example.commons

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*


abstract class BaseListFragment : BaseFragment() {

    val listAdapter: RecyclerView.Adapter<*>
        get() = getAdapter()

    override fun getLayoutResId(): Int {
        return R.layout.fragment_list
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.adapter = listAdapter
        list.layoutManager = LinearLayoutManager(context)
    }


    abstract fun getAdapter(): RecyclerView.Adapter<*>

}