package edu.uc.brown5a7.BottomsUp.dto

import androidx.room.Entity
import com.google.firebase.database.Exclude
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Drinks")
data class Drink(@SerializedName("id") var drinkId : String = "0", var category : String = "", var brand : String = "", var name : String = "", var comment : String = "", var rating : String = "") {
    override fun toString() : String{
        return "$category $brand $name $comment $rating"
    }

    private var _events : ArrayList<Drink> = ArrayList<Drink>()


    var events : ArrayList<Drink>
        @Exclude get() {return _events}
        set(value) {_events = value}
}