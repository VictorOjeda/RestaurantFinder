package com.victorojeda.restaurantfinder.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.victorojeda.restaurantfinder.SearchQuery

class YelpGqlClient constructor(private val apolloClient: ApolloClient) {
    suspend fun search(latitude: Double, longitude: Double): List<SearchQuery.Business> {
        val query = SearchQuery(latitude, longitude, 5000.0)
        val response = apolloClient.query(query).toDeferred().await()

        val businesses = response.data?.search?.business?.filterNotNull()
        return when {
            businesses == null -> listOf()
            response.hasErrors() -> throw Exception(response.errors?.get(0)?.message)
            else -> businesses
        }
    }
}