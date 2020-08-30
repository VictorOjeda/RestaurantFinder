package com.victorojeda.restaurantfinder.di

import com.apollographql.apollo.ApolloClient
import com.victorojeda.restaurantfinder.repository.TokenInterceptor
import com.victorojeda.restaurantfinder.repository.YelpGqlClient
import com.victorojeda.restaurantfinder.repository.YelpRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .build()
    }

    @Provides
    fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://api.yelp.com/v3/graphql")
            .okHttpClient(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideYelpGqlClient(apolloClient: ApolloClient): YelpGqlClient {
        return YelpGqlClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideYelpRepository(yelpGqlClient: YelpGqlClient): YelpRepository {
        return YelpRepository(yelpGqlClient)
    }
}