package com.kesuyobo.yourweatherAN.API


sealed class Networkresult <out T> {

        object Loading : Networkresult<Nothing>()
        data class Success<out T>(val data : T) : Networkresult<T>()
        data class Error(val message : String) : Networkresult<Nothing>()

    }