package edu.uc.brown5a7.BottomsUp.searchadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.uc.brown5a7.BottomsUp.R
import edu.uc.brown5a7.BottomsUp.dto.Drink
import kotlinx.android.synthetic.main.row.view.*
import kotlin.collections.ArrayList

class DrinkAdapter(val context: Context, var drinks: ArrayList<Drink>) : RecyclerView.Adapter<DrinkAdapter.MyViewHolder>(){
    private var drinkListFull: ArrayList<Drink> = ArrayList(drinks)

    inner class MyViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentdrink : Drink? = null;
        var currentPosition : Int = 0
        private lateinit var currentDrink: Drink

        init{
            itemView.setOnClickListener {
                Toast.makeText(context, currentdrink!!.name + " Clicked !", Toast.LENGTH_SHORT).show()
                // this is just a place holder. in future it will open the full details page for the clicked drink
            }
        }

        fun setData(drink: Drink?, pos: Int) {
            itemView.drinkName.text = drink!!.name

            this.currentdrink = drink
            this.currentPosition = pos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drinkListFull.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val drink = drinkListFull[position]
        holder.setData(drink, position)
    }

    //
    @get:Override
    val filter: Filter
        get() = drinkFilter

    private val drinkFilter: Filter = object : Filter() {
        @Override
        protected override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList: ArrayList<Drink> = ArrayList()
            if (constraint == null || constraint.isBlank()) {
                // might need to change isBlank back to .length === 0
                filteredList.addAll(drinkListFull)
            } else {
                val filterPattern: String = constraint.toString().toLowerCase().trim()
                for (item in drinkListFull) {
                    if (item!!.name.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        @Override
        protected override fun publishResults(constraint: CharSequence?, results: FilterResults) {
            drinks.clear()
            drinks.addAll(results.values as ArrayList<Drink>)
            notifyDataSetChanged()
        }
    }

    init {
        this.drinks = drinks
        drinkListFull = ArrayList(drinks)
    }

}