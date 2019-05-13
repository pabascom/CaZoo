package phil.homework.week2day1zoo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import phil.homework.week2day1zoo.Animal
import phil.homework.week2day1zoo.R
import phil.homework.week2day1zoo.utils.inflate

class AnimalListAdapter (val listContext: Context, val resource: Int, val animalList: List<Animal>) : ArrayAdapter<Animal>(listContext, resource, animalList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = LayoutInflater.from(listContext).inflate(resource, parent, false)

        val tvAnimalName = view.findViewById<TextView>(R.id.tvAnimalName)
        val tvAnimalType = view.findViewById<TextView>(R.id.tvAnimalType)
        val tvAnimalSpecies = view.findViewById<TextView>(R.id.tvAnimalSpecies)
        val tvAnimalWeight = view.findViewById<TextView>(R.id.tvAnimalWeight)

        tvAnimalName.text = animalList[position].name
        tvAnimalType.text= animalList[position].type.toString()
        tvAnimalSpecies.text = animalList[position].species
        tvAnimalWeight.text = animalList[position].weight.toString()

         return view
    }

}

class AnimalAdapter(val animalList: List<Animal>): RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    val NORMAL = 0
    val BIGBOI = 1

    override fun getItemViewType(position: Int): Int {
        return if(animalList[position].weight > 200) BIGBOI
        else NORMAL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType) {
            BIGBOI -> BigBoiViewHolder(parent.inflate(R.layout.recycler_item_large_animal))
            else -> NormalViewHolder(parent.inflate(R.layout.recycler_item_animal))
        }
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val animal = animalList[position]
        viewHolder.tvAnimalName.text = animal.name
        viewHolder.tvAnimalType.text= animal.type.toString()
        viewHolder.tvAnimalSpecies.text = animal.species
        viewHolder.tvAnimalWeight.text = animal.weight.toString()
    }

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAnimalName = itemView.findViewById<TextView>(R.id.tvAnimalName)
        val tvAnimalType = itemView.findViewById<TextView>(R.id.tvAnimalType)
        val tvAnimalSpecies = itemView.findViewById<TextView>(R.id.tvAnimalSpecies)
        val tvAnimalWeight = itemView.findViewById<TextView>(R.id.tvAnimalWeight)
    }

    class NormalViewHolder(itemView: View) : ViewHolder(itemView)

    class BigBoiViewHolder(itemView: View) : ViewHolder(itemView)
}