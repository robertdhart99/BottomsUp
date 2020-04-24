package edu.uc.brown5a7.BottomsUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.searchadapter.DrinkAdapter
import edu.uc.brown5a7.BottomsUp.service.DrinkService
import edu.uc.brown5a7.BottomsUp.ui.main.MainFragment
import edu.uc.brown5a7.BottomsUp.ui.main.SignUpFragment

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    lateinit var toolbar: ActionBar

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_search -> {
                toolbar.title = "Search"
                val searchFragment = MainFragment.newInstance()
                openFragment(searchFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_user -> {
                toolbar.title = "User"
                val userFragment = SignUpFragment.newInstance()
                openFragment(userFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        var drinks : MutableLiveData<ArrayList<Drink>> = MutableLiveData()
        var drinkService : DrinkService = DrinkService()
        drinks = drinkService.fetchDrinks("blank")
        val drinksFullList : ArrayList<Drink> = drinks as ArrayList<Drink>
        val adapter = DrinkAdapter(this, drinksFullList)
        recyclerView.adapter = adapter

        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
