package com.kesuyobo.yourweatherAN

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kesuyobo.yourweatherAN.API.ConstAPI
import com.kesuyobo.yourweatherAN.API.Networkresult
import com.kesuyobo.yourweatherAN.API.RInstance
import com.kesuyobo.yourweatherAN.API.W_modle
import com.kesuyobo.yourweatherAN.API.WeatherAPI
import kotlinx.coroutines.launch


class WeatherViewModel : ViewModel() {
    private val weatherapi = RInstance.weatherApi
    private val _weatherResult = MutableLiveData<Networkresult<W_modle>>()
    val weatherResult : LiveData<Networkresult<W_modle>> = _weatherResult

    fun getData (city_name: String){
        _weatherResult.value = Networkresult.Loading
        viewModelScope.launch {
            try{
                val response = weatherapi.getW(ConstAPI.apikey,city_name)
                if(response.isSuccessful){
                    response.body()?.let {
                        _weatherResult.value = Networkresult.Success(it)
                    }
                }else{
                    _weatherResult.value = Networkresult.Error("Can't load data for $city_name")
                }
            }
            catch (e : Exception){
                _weatherResult.value = Networkresult.Error("Can't load data for $city_name")
            }

        }
    }
}