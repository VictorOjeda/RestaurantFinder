package com.victorojeda.restaurantfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victorojeda.restaurantfinder.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FinderActivity"

@AndroidEntryPoint
class RestaurantFinderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_finder)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            val fragment = SearchFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}