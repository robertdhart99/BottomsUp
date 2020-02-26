package edu.uc.brown5a7.BottomsUp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.service.DrinkService
import edu.uc.brown5a7.BottomsUp.ui.main.MainViewModel
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DrinkDTOMockkUnitTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mvm: MainViewModel

    var drinkService = mockk<DrinkService>()

    @Test
    fun searchForCoke_returnsCoke(){
        givenAFeedOfMockkedDrinkDataAreAvailable()
        whenSearchForCoke()
        thenResultContainsCoke()
        thenVerifiedCokeFunctionsEnvoked()
    }

    private fun thenVerifiedCokeFunctionsEnvoked() {
        verify { drinkService.fetchDrinks("coke") }
        verify(exactly = 0) {drinkService.fetchDrinks("aadskfl") }
        confirmVerified(drinkService)
    }

    private fun givenAFeedOfMockkedDrinkDataAreAvailable() {
        mvm = MainViewModel()
        createMockkData()
    }

    private fun createMockkData() {
        var allDrinkLiveData = MutableLiveData<ArrayList<Drink>>()
        var allDrinks = ArrayList<Drink>()

        //create mockk drink
        var coke = Drink("26", "soda", "coca-cola", "coke", "Really good on a warm day!", "4")
        allDrinks.add(coke)
        var MariageFreres = Drink("61", "Tea", "Marco Polo Blue", "Mariage Freres",  "My Favorite French Tea", "5")
        allDrinks.add(MariageFreres)
        allDrinkLiveData.postValue(allDrinks)

        every {drinkService.fetchDrinks(or("coke", "Mariage Freres"))} returns allDrinkLiveData
        every {drinkService.fetchDrinks(not(or("coke", "Mariage Freres")))} returns MutableLiveData<ArrayList<Drink>>()

        mvm.drinkService = drinkService
    }

    private fun whenSearchForCoke() {
        mvm.fetchDrinks("coke")
    }

    private fun thenResultContainsCoke() {
        var cokeFound = false

        mvm.drinks.observeForever {
            //observe the drink data
            assertNotNull(it)
            assertTrue(it.size > 0)
            it.forEach {
                if (it.name.contains("coke") && it.brand.contains("coca-cola") && it.category == "soda" && it.drinkId == "26" && it.comment.contains("Really good on a warm day!") && it.rating == "4") {
                    cokeFound = true
                }
            }
        }
        assertTrue(cokeFound)
    }

    @Test
    fun searchForMariageFreres_returnsMariageFreres(){
        givenAFeedOfMockkedDrinkDataAreAvailable()
        whenSearchForMariageFreres()
        thenResultContainsMariageFreres()
        thenVerifiedMariageFreresFunctionsEnvoked()
    }

    private fun thenVerifiedMariageFreresFunctionsEnvoked() {
        verify { drinkService.fetchDrinks("Mariage Freres") }
        verify(exactly = 0) {drinkService.fetchDrinks("aadskfl") }
        confirmVerified(drinkService)
    }

    private fun whenSearchForMariageFreres() {
        mvm.fetchDrinks("Mariage Freres")
    }

    private fun thenResultContainsMariageFreres() {
        var MariageFreresFound = false

        mvm.drinks.observeForever {
            //observe the drink data
            assertNotNull(it)
            assertTrue(it.size > 0)
            it.forEach {
                if (it.name.contains("Mariage Freres") && it.brand.contains("Marco Polo Blue") && it.category == "Tea" && it.drinkId == "61" && it.comment.contains("My Favorite French Tea") && it.rating == "5") {
                    MariageFreresFound = true
                }
            }
        }
        assertTrue(MariageFreresFound)
    }

    @Test
    fun searchForGarbage_ReturnsNothing(){
        givenAFeedOfMockkedDrinkDataAreAvailable()
        whenISearchForGarbage()
        thenIGetZeroResults()
    }

    private fun whenISearchForGarbage() {
        mvm.fetchDrinks("asdflkj")
    }

    private fun thenIGetZeroResults() {
        mvm.drinks.observeForever{
            assertEquals(0, it.size)
        }
    }

}
