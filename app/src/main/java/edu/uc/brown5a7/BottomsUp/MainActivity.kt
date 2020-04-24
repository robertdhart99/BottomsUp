package edu.uc.brown5a7.BottomsUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.searchAdaptor.drinkAdapter
import edu.uc.brown5a7.BottomsUp.service.DrinkService
//import edu.uc.brown5a7.BottomsUp.searchAdapter.DrinkAdapter
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_fragment)


        var drinks: MutableLiveData<ArrayList<Drink>> = MutableLiveData()
        var drinkService: DrinkService = DrinkService()
        drinks = drinkService.fetchDrinks("blank")
        val drinksFullList: ArrayList<Drink> = drinks as ArrayList<Drink>
        val adapter = drinkAdapter(this, drinksFullList)
        recyclerView.adapter = adapter

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_recents:
                    Toast.makeText(MainActivity.this, "Recents", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.action_favorites:
                    Toast.makeText(MainActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.action_nearby:
                    Toast.makeText(MainActivity.this, "Nearby", Toast.LENGTH_SHORT).show();
                    break;                }
                return true;
            }
        });
    }
    }
}
