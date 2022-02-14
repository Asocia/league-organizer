package com.example.leagueorganizer.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://randommer.io/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TeamsApiService {
    @Headers("X-Api-Key: 437ce6edb8474cab8728c5e32a9dfd9a")
    @GET("Name")
    suspend fun getTeamNames(@Query("nameType") nameType: String,
                             @Query("quantity") quantity: String): List<String>
}

object TeamsApi {
    val RETROFIT_SERVICE : TeamsApiService by lazy {
        retrofit.create(TeamsApiService::class.java)
    }
}
