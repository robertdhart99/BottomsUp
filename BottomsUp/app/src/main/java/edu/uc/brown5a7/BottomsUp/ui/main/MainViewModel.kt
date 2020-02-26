package edu.uc.brown5a7.BottomsUp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.service.DrinkService

class MainViewModel : ViewModel() {
    var drinks: MutableLiveData<ArrayList<Drink>> = MutableLiveData()
    var drinkService: DrinkService = DrinkService()

    fun fetchDrinks(name: String) {
        drinks = drinkService.fetchDrinks(name)
    }


    fun comment()
    {
        //this is a test comment to check for circle ci integration
    }
    // TODO: Implement the ViewModel
}
