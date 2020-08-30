package com.victorojeda.restaurantfinder.repository

import com.victorojeda.restaurantfinder.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${BuildConfig.YELP_API_KEY}")
            .build()
        return chain.proceed(newRequest)
    }
}