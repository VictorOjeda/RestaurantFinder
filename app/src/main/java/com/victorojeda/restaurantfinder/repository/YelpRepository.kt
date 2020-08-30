package com.victorojeda.restaurantfinder.repository

import com.victorojeda.restaurantfinder.model.Business

class YelpRepository constructor(private val yelpGqlClient: YelpGqlClient) {
    suspend fun search(latitude: Double, longitude: Double): List<Business> {
        return yelpGqlClient.search(latitude, longitude)
            .map { Business(it.name ?: "") }
    }
}