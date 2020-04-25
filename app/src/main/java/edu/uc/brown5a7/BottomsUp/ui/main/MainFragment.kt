package edu.uc.brown5a7.BottomsUp.ui.main

import MainViewModel
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uc.brown5a7.BottomsUp.R
import edu.uc.brown5a7.BottomsUp.dto.Drink
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.row.*


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
        activity.let {
            viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        }

        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = DrinksAdapter(viewModel.beverage.events, R.layout.row)
    }

    //adapter for our drink class from main fragment

    inner class DrinksAdapter(val events: List<Drink>, val itemLayout: Int) : RecyclerView.Adapter<MainFragment.EventViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
            return EventViewHolder(view)
        }

        override fun getItemCount(): Int {
            return events.size
        }

        override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
            val event = events.get(position)
            holder.updateEvent(event)
        }
    }

    inner class EventViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var dataValue : TextView = itemView.findViewById(R.id.drinkName)

        /**
         * shows drink data from recyclerView in single row
         */
        fun updateEvent (event : Drink) {
            drinkName.text = event.toString()
        }
    }

}
