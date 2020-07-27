package com.example.gameapp.deals


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


class DealsFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals() {
        GameDataSource
            .getDeals()
            ?.subscribe({ list ->
                replaceItems(list)
            }, {error ->
                showError(error)
            })
    }

    private fun replaceItems(list: List<Deal>){
        with(listAdapter as DataBindingRecyclerAdapter<Deal>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }

    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
        Snackbar.make(view!!, R.string.error_request, Snackbar.LENGTH_LONG)
            .setAction(R.string.label_retry, { view: View -> showDeals()})
    }


}