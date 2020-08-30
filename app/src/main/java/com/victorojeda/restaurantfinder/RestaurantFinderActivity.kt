package com.victorojeda.restaurantfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.victorojeda.restaurantfinder.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "FinderActivity"

@AndroidEntryPoint
class RestaurantFinderActivity : AppCompatActivity() {

    private val searchViewModel by viewModels<SearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_finder)

        searchViewModel.findRestaurantsNearMe(33.4028076, -111.901385)
    }
}