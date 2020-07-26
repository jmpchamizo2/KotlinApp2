package com.example.gameapp.rated

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BR
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.example.gameapp.R
import com.example.gameapp.TopGame

class TopRatedFragment : BaseListFragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<TopGame>)
            .items.addAll(getDummyTopGame())
        listAdapter.notifyDataSetChanged()
    }

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopRatedFragment>(BR.topGame, R.layout.item_top_game)
    }


    fun getDummyTopGame(): ArrayList<TopGame> {
        return arrayListOf<TopGame>(
            TopGame("Counter Strike",
                13407338,
                80,
                "Valve",
                9.99F,
                1,
                "http://cdn.akamai.steamstatic.com/steam/apps/10/capsule_184x69.jpg"))
    }
}