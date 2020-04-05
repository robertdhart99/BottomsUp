package edu.uc.brown5a7.BottomsUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.searchAdaptor.drinkAdapter
import edu.uc.brown5a7.BottomsUp.service.DrinkService
//import edu.uc.brown5a7.BottomsUp.searchAdapter.DrinkAdapter
import edu.uc.brown5a7.BottomsUp.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        var drinks : MutableLiveData<ArrayList<Drink>> = MutableLiveData()
        var drinkService : DrinkService = DrinkService()
        drinks = drinkService.fetchDrinks("blank")
        val drinksFullList : ArrayList<Drink> = drinks as ArrayList<Drink>
        val adapter = drinkAdapter(this, drinksFullList)
        recyclerView.adapter = adapter


    }
}
