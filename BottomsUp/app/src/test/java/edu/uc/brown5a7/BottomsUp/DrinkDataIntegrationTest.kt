package edu.uc.brown5a7.BottomsUp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import edu.uc.brown5a7.BottomsUp.service.DrinkService
import edu.uc.brown5a7.BottomsUp.ui.main.MainViewModel
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class DrinkDataIntegrationTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mvm: MainViewModel

    var drinkService = mockk<DrinkService>()

    @Before
    fun setUp()
    {
        mvm = MainViewModel()
    }

    @Test
    fun searchForCoke_returnsCoke(){
        whenSearchForCoke()
        thenResultContainsCoke()
    }

    private fun whenSearchForCoke() {
        mvm.fetchDrinks("coke")
    }

    private fun thenResultContainsCoke() {
        var cokeFound = false

        mvm.drinks.observeForever {
            //observe the drink data
            Assert.assertNotNull(it)
            Assert.assertTrue(it.size > 0)
            it.forEach {
                if (it.name == "coke" && it.brand == "coca-cola" && it.category == "soda" && it.drinkId == "26" && it.comment.contains("Really good on a warm day!") && it.rating == "4") {
                    cokeFound = true
                }
            }
            Assert.assertTrue(cokeFound)
        }
    }

    @Test
    fun searchForMariageFreres_returnsMariageFreres(){
        whenSearchForMariageFreres()
        thenResultContainsMariageFreres()
    }

    private fun whenSearchForMariageFreres() {
        mvm.fetchDrinks("Mariage Freres")
    }

    private fun thenResultContainsMariageFreres() {
        var MariageFreresFound = false

        mvm.drinks.observeForever {
            //observe the drink data
            Assert.assertNotNull(it)
            Assert.assertTrue(it.size > 0)
            it.forEach {
                if (it.name.contains("Mariage Freres") && it.brand.contains("Marco Polo Blue") && it.category == "Tea" && it.drinkId == "61" && it.comment.contains("My Favorite French Tea") && it.rating == "5") {
                    MariageFreresFound = true
                }
            }
            Assert.assertTrue(MariageFreresFound)
        }
    }

    @Test
    fun searchForGarbage_ReturnsNothing(){
        whenISearchForGarbage()
        thenIGetZeroResults()
    }

    private fun whenISearchForGarbage() {
        mvm.fetchDrinks("asdflkj")
    }

    private fun thenIGetZeroResults() {
        mvm.drinks.observeForever{
            Assert.assertEquals(0, it.size)
        }
    }

    @Test
    fun searchForCategory_ReturnAppropriateDrinks(){
        whenSearchForSoda()
        theResultContainsCokeAndPepsi()
    }

    private fun whenSearchForSoda() {
        mvm.fetchCategory("soda")
    }

    private fun theResultContainsCokeAndPepsi() {
        var sodaFound = false

        mvm.drinks.observeForever {
            //observe the drink data
            Assert.assertNotNull(it)
            Assert.assertTrue(it.size > 0)
            it.forEach {
                if ((it.name == "coke" && it.brand == "coca-cola" && it.category == "soda" && it.drinkId == "26" && it.comment.contains("Really good on a warm day!") && it.rating == "4") && (it.name == "Pepsi" && it.brand == "Pepsi Co" && it.category == "soda" && it.drinkId == "27" && it.comment.contains("An american classic drink. the perfect cola for anything") && it.rating == "5")) {
                    sodaFound = true
                }
            }
            Assert.assertTrue(sodaFound)
        }
    }

}