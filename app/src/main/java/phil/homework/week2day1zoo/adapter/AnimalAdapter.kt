package phil.homework.week2day1zoo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import phil.homework.week2day1zoo.Animal
import phil.homework.week2day1zoo.R
import kotlinx.android.synthetic.main.list_item_animal.*

class AnimalAdapter (val listContext: Context, val resource: Int, val animalList: List<Animal>) : ArrayAdapter<Animal>(listContext, resource, animalList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        view = LayoutInflater.from(listContext).inflate(resource, parent, false)

        val tvAnimalName = view.findViewById<TextView>(R.id.tvAnimalName)
        val tvAnimalType = view.findViewById<TextView>(R.id.tvAnimalType)
        val tvAnimalSpecies = view.findViewById<TextView>(R.id.tvAnimalSpecies)
        val tvAnimalWeight = view.findViewById<TextView>(R.id.tvAnimalWeight)

        tvAnimalName.text = animalList[position].name
        tvAnimalType.text= animalList[position].type
        tvAnimalSpecies.text = animalList[position].species
        tvAnimalWeight.text = animalList[position].weight.toString()

         return view
    }

}