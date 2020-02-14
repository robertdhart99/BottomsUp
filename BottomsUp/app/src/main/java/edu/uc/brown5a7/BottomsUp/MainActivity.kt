package edu.uc.brown5a7.BottomsUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uc.brown5a7.BottomsUp.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow();

            //test 
        }
    }

    fun FBTest() {
        //function to return firebase object
    }

}
