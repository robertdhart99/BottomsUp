package edu.uc.brown5a7.BottomsUp.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import edu.uc.brown5a7.BottomsUp.R
import kotlinx.android.synthetic.main.main_fragment.*
import android.widget.ArrayAdapter
import android.widget.AdapterView


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.drinks.observe(this, Observer {
            drinks -> actDrinkName.setAdapter(ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, drinks))
        })
    }

}
