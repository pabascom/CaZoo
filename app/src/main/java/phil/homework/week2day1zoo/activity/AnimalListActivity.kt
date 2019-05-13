package phil.homework.week2day1zoo.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_animal_list.*
import kotlinx.android.synthetic.main.activity_animal_types_list.*
import phil.homework.week2day1zoo.BaseActivity
import phil.homework.week2day1zoo.R
import phil.homework.week2day1zoo.adapter.AnimalAdapter
import phil.homework.week2day1zoo.data.AnimalDatabase
import phil.homework.week2day1zoo.data.AnimalType

class AnimalListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        val animalDb = AnimalDatabase(applicationContext, "animals", 1)
        val type = intent.getSerializableExtra("type") as AnimalType

        //Toast.makeText(applicationContext, "Loaded with type $type", Toast.LENGTH_LONG).show()

        tvAnimalType.text = type.toString()
        rvAnimals.layoutManager = LinearLayoutManager(this)
        rvAnimals.adapter = AnimalAdapter(
            animalDb.getAnimalsByType(type)
        )
    }
}
