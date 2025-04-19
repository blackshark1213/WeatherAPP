package com.kesuyobo.yourweatherAN.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RInstance {

        private const val Url = "https://api.weatherapi.com";


        private fun getInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val weatherApi : WeatherAPI = getInstance().create(WeatherAPI::class.java)

    }