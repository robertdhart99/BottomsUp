package edu.uc.brown5a7.BottomsUp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://bottomsup-f3e22.firebaseio.com"

    val retrofitInstance : Retrofit?
        get(){
            // has this drink been created yet
            if(retrofit == null){
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}