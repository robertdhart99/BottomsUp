package edu.uc.brown5a7.BottomsUp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import edu.uc.brown5a7.BottomsUp.dto.Drink
import edu.uc.brown5a7.BottomsUp.searchadapter.drinkAdapter
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/*
 * Integration test for drinkAdapter.kt
 */

class DrinkAdapterIntegrationTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var drinkAdapter: drinkAdapter
    lateinit var mainActivity: MainActivity
    var drinkCount = 0

    @Before
    fun setUp()
    {
        mainActivity = MainActivity()
    }

    @Ignore
    @Test
    fun testConstructorStoresValuesCorrectly()
    {
        givenDrinkAdapterCreatedWithDrinks()
        whenGetItemCountIsCalled()
        thenDrinkCountMatchesItemCount(2)
    }

    private fun givenDrinkAdapterCreatedWithDrinks() {
        val drinks = ArrayList<Drink>()
        val drink0 = Drink("0", "Soda", "Coke", "Coke", "Coca-cola", "5")
        val drink1 = Drink("1", "Soda", "Pepsi", "Pepsi", "Bepis", "4")
        drinks.add(drink0)
        drinks.add(drink1)
        drinkAdapter = drinkAdapter(mainActivity, drinks)
    }

    private fun whenGetItemCountIsCalled() {
        drinkCount = drinkAdapter.itemCount
    }

    private fun thenDrinkCountMatchesItemCount(itemCount : Int)
    {
        var result = false
        if (drinkCount == itemCount)
        {
            result = true
        }
        assertTrue(result)
    }
}
