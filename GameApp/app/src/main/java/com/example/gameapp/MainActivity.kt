package com.example.gameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.gameapp.deals.DealsFragment
import com.example.gameapp.owned.TopOwnedFragment
import com.example.gameapp.rated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val DEFAULT_OPTION: Int = R.id.action_deals

    val fragments: HashMap<Int, Fragment> = hashMapOf(
        Pair(R.id.action_deals, DealsFragment()),
        Pair(R.id.action_most_owned, TopOwnedFragment()),
        Pair(R.id.action_top_rated, TopRatedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        navigatonView.selectedItemId = DEFAULT_OPTION
        navigatonView.setOnNavigationItemSelectedListener { item ->
            fragments[item.itemId]?.let { replaceFragment(it) }

            true
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun initView() {
        val currentFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer)

        if (currentFragment == null){
            fragments[DEFAULT_OPTION]?.let {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, it)
                    .commit()
            }
        }
    }
}