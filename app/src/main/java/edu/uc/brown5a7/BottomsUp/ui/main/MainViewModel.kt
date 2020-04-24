import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.service.DrinkService
import edu.uc.brown5a7.BottomsUp.service.DrinkCategoryService

class MainViewModel : ViewModel() {
    var drinks : MutableLiveData<ArrayList<Drink>> = MutableLiveData()
    var drinkService : DrinkService = DrinkService()
    var categories : MutableLiveData<ArrayList<Drink>> = MutableLiveData()
    var drinkCategoryService : DrinkCategoryService = DrinkCategoryService()

    fun fetchDrinks(name : String) {
        drinks = drinkService.fetchDrinks(name)
    }
    fun fetchCategory(category : String) {
        categories = drinkCategoryService.fetchCategory(category)
    }
}