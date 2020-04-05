package edu.uc.brown5a7.BottomsUp.dto

import com.google.gson.annotations.SerializedName

data class Drink(@SerializedName("id") var drinkId : String = "0", var category : String, var brand : String, var name : String, var comment : String, var rating : String) {

    override fun toString() : String{
        return "$category $brand $name $comment $rating"
    }
}