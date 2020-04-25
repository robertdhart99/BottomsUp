import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.service.DrinkService
import edu.uc.brown5a7.BottomsUp.service.DrinkCategoryService
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class MainViewModel : ViewModel() {
    private var _beverages : MutableLiveData<ArrayList<Drink>> = MutableLiveData<ArrayList<Drink>>()
    private var _beverage = Drink()
    var drinks : MutableLiveData<ArrayList<Drink>> = MutableLiveData()
    var drinkService : DrinkService = DrinkService()
    var categories : MutableLiveData<ArrayList<Drink>> = MutableLiveData()
    var drinkCategoryService : DrinkCategoryService = DrinkCategoryService()
    private lateinit var firestore : FirebaseFirestore



    fun fetchDrinks(name : String) {
        drinks = drinkService.fetchDrinks(name)
    }
    fun fetchCategory(category : String) {
        categories = drinkCategoryService.fetchCategory(category)
    }

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
        listenToDrinks()
    }

    private fun listenToDrinks() {
        firestore.collection("Drinks").addSnapshotListener {
                snapshot, e ->
            if(e != null)
            {

            }

            if(snapshot != null) {
                val allDrinks = ArrayList<Drink>()
                val documents = snapshot.documents
                documents.forEach {
                    val beverage = it.toObject(Drink::class.java)
                    if(beverage != null) {
                        beverage.drinkId = it.id
                        allDrinks.add(beverage!!)
                    }
                }
                _beverages.value = allDrinks
            }
        }
    }

    internal var beverage: Drink
        get() { return _beverage}
        set(value) {_beverage = value}
}