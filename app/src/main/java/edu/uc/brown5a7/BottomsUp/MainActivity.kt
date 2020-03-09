package edu.uc.brown5a7.BottomsUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.searchAdaptor.DrinkAdapter
import edu.uc.brown5a7.BottomsUp.service.DrinkService
import kotlinx.android.synthetic.main.main_fragment.*

//import edu.uc.brown5a7.BottomsUp.searchAdapter.DrinkAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: LayoutManager
    private lateinit var drinkAdapter: DrinkAdapter
    private var drinks: MutableLiveData<ArrayList<Drink>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)

        initRecyclerView()
        //UNCOMMENT THESE LINES WHEN CASTING HAS BEEN WORKED OUT FOR drinksFullList:
        val drinksFullList: ArrayList<Drink> = drinks as ArrayList<Drink> //ClassCastException: androidx.lifecycle.MutableLiveData cannot be cast to java.util.ArrayList
        drinkAdapter = DrinkAdapter(this, drinksFullList)
        recycler_view.adapter = drinkAdapter
    }

    private fun initRecyclerView() {
        val drinkService = DrinkService()
        drinks = drinkService.fetchDrinks("blank")
        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
    }
}
