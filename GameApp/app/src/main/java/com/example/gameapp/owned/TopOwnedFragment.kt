package com.example.gameapp.owned

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BR
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.example.gameapp.R
import com.example.gameapp.TopGame

class TopOwnedFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<TopGame>)
            .items.addAll(getDummyTopGame())
        listAdapter.notifyDataSetChanged()
    }


    fun getDummyTopGame(): ArrayList<TopGame> {
        return arrayListOf<TopGame>(
            TopGame("Counter Strike",
            13407338,
            80,
            "Valve",
            9.99F,
                1,
                "https://www.beahero.gg/wp-content/uploads/2020/04/Counter-Strike-Global-Offensive-imagen1-.jpg"))
    }
}