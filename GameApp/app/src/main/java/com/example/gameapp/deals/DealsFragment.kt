package com.example.gameapp.deals

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BR
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.example.gameapp.Deal
import com.example.gameapp.R

class DealsFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<Deal>)
            .items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyDeals(): ArrayList<Deal> {
        return arrayListOf<Deal>(Deal("Counter Strike",
        0.99F,
        9.99F,
        80,
        80,
            "https://www.beahero.gg/wp-content/uploads/2020/04/Counter-Strike-Global-Offensive-imagen1-.jpg"))
    }
}