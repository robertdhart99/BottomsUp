package edu.uc.brown5a7.BottomsUp.service

import androidx.lifecycle.MutableLiveData
import edu.uc.brown5a7.BottomsUp.RetrofitClientInstance
import edu.uc.brown5a7.BottomsUp.dao.IDrinkDAO
import edu.uc.brown5a7.BottomsUp.dto.Drink
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrinkService {

    fun fetchDrinks(name: String) : MutableLiveData<ArrayList<Drink>> {
        val _drinks = MutableLiveData<ArrayList<Drink>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(IDrinkDAO::class.java)
        val call = service?.getAllDrinks()
        call?.enqueue(object: Callback<ArrayList<Drink>> {
            override fun onFailure(call: Call<ArrayList<Drink>>, t: Throwable) {
                val i = 1 + 1
                val j = 1 + 1
            }

            override fun onResponse(
                call: Call<ArrayList<Drink>>,
                response: Response<ArrayList<Drink>>
            ) {
                _drinks.value = response.body()
            }

        })

        return _drinks
    }

    fun fetchCategory(category: String) : MutableLiveData<ArrayList<Drink>> {
        val _category = MutableLiveData<ArrayList<Drink>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(IDrinkDAO::class.java)
        val call = service?.getAllDrinks()
        call?.enqueue(object: Callback<ArrayList<Drink>> {
            override fun onFailure(call: Call<ArrayList<Drink>>, t: Throwable) {
                val i = 1 + 1
                val j = 1 + 1
            }

            override fun onResponse(
                call: Call<ArrayList<Drink>>,
                response: Response<ArrayList<Drink>>
            ) {
                _category.value = response.body()
            }

        })

        return _category
    }
}