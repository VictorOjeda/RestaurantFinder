package com.victorojeda.restaurantfinder

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RestaurantFinderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}