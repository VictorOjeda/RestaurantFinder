package com.victorojeda.restaurantfinder.search

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victorojeda.restaurantfinder.model.Business
import com.victorojeda.restaurantfinder.repository.YelpRepository
import kotlinx.coroutines.launch

private const val TAG = "SearchViewModel"
class SearchViewModel @ViewModelInject constructor(private val yelpRepository: YelpRepository)
    : ViewModel() {

    private val _businesses = MutableLiveData<List<Business>>()
    val businesses : LiveData<List<Business>> = _businesses

    fun findRestaurantsNearMe(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            val business = yelpRepository.search(latitude, longitude)
            Log.d(TAG, "Businesses: $business")
            _businesses.postValue(business)
        }
    }
}