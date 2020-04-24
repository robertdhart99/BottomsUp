package edu.uc.brown5a7.BottomsUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.searchAdaptor.drinkAdapter
import edu.uc.brown5a7.BottomsUp.service.DrinkService
import edu.uc.brown5a7.BottomsUp.ui.main.MainFragment
import edu.uc.brown5a7.BottomsUp.ui.main.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mainFragment: MainFragment
    private lateinit var activeFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        recyclerView.layoutManager = layoutManager
//
//        var drinks : MutableLiveData<ArrayList<Drink>> = MutableLiveData()
//        var drinkService : DrinkService = DrinkService()
//        drinks = drinkService.fetchDrinks("blank")
//        val drinksFullList : ArrayList<Drink> = drinks as ArrayList<Drink>
//        val adapter = drinkAdapter(this, drinksFullList)
        //recyclerView.adapter = adapter


    }
}
