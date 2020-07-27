package com.example.gameapp.owned

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BR
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.example.gameapp.Deal
import com.example.gameapp.R
import com.example.gameapp.TopGame
import com.example.gameapp.data.GameDataSource
import com.google.android.material.snackbar.Snackbar

class TopOwnedFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onResume() {
        super.onResume()
        showTopOwned()
    }

    private fun showTopOwned() {
        GameDataSource
            .getMostOwnedGames()
            ?.subscribe({ list ->
                replaceItems(list)
            }, {error ->
                showError(error)
            })
    }

    private fun replaceItems(list: List<TopGame>){
        with(listAdapter as DataBindingRecyclerAdapter<TopGame>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }

    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
        Snackbar.make(view!!, R.string.error_request, Snackbar.LENGTH_LONG)
            .setAction(R.string.label_retry, { view: View -> showTopOwned()})
    }

}