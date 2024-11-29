package com.example.rasanusa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rasanusa.data.api.ApiConfig
import com.example.rasanusa.data.response.FoodResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodViewModel : ViewModel() {
    private val _foodDetail = MutableLiveData<FoodResponse>()
    val foodDetail: LiveData<FoodResponse> get() = _foodDetail

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun getFoodDetail(predictClass: String){
        _isLoading.value = true
        val client = ApiConfig.getApiService()
        client.getDetail(predictClass).enqueue(object : Callback<FoodResponse>{
            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
                _isLoading.value = false
                if (response.isSuccessful && response.body() != null){
                    _foodDetail.value = response.body()
                }else{

                }
            }

            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}