package edu.uc.brown5a7.BottomsUp.dao

import edu.uc.brown5a7.BottomsUp.dto.Drink
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IDrinkDAO {

    @GET("/Drink.json")
    fun getAllDrinks(): Call<ArrayList<Drink>>

    @GET("/Drink.json")
    fun getDrinks(@Query("Combined_Name") CountryName:String) : Call<ArrayList<Drink>>
}