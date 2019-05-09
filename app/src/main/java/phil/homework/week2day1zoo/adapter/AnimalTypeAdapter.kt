package phil.homework.week2day1zoo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import phil.homework.week2day1zoo.R

class AnimalTypeAdapter (val listContext: Context, val resource: Int, val typeList: List<String>) : ArrayAdapter<String>(listContext, resource, typeList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(listContext).inflate(resource, parent, false)

        val tvAnimalType = view.findViewById<TextView>(R.id.tvAnimalType)

        tvAnimalType.text= typeList[position]

        return view
    }

}