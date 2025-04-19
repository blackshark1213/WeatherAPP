package com.kesuyobo.yourweatherAN.API

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("/v1/current.json")
    suspend fun getW(
        @Query("key") api_key : String,
        @Query("q")city_name : String
    ): Response<W_modle>
}