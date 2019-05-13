package phil.homework.week2day1zoo.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_animal_types_list.*
import phil.homework.week2day1zoo.BaseActivity
import phil.homework.week2day1zoo.R
import phil.homework.week2day1zoo.adapter.AnimalAdapter
import phil.homework.week2day1zoo.adapter.AnimalTypeAdapter
import phil.homework.week2day1zoo.data.AnimalDatabase
import phil.homework.week2day1zoo.data.AnimalType

class AnimalTypesListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_types_list)

        lvAnimals.adapter = AnimalTypeAdapter(
            applicationContext,
            R.layout.list_item_animal_type,
            AnimalType.values().map { it.toString() }
        )

        lvAnimals.setOnItemClickListener { parent, view, position, id ->
            startActivity(
                Intent(applicationContext, AnimalListActivity::class.java).putExtra(
                    "type",
                    AnimalType.values()[position]
                )
            )
            //Toast.makeText(applicationContext, AnimalType.values()[position].toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
