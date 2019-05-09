package phil.homework.week2day1zoo.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_browser.*
import phil.homework.week2day1zoo.BaseActivity
import phil.homework.week2day1zoo.R
import phil.homework.week2day1zoo.adapter.AnimalAdapter
import phil.homework.week2day1zoo.adapter.AnimalTypeAdapter
import phil.homework.week2day1zoo.data.AnimalDatabase
import phil.homework.week2day1zoo.data.AnimalType

class AnimalBrowserActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_browser)

        val animalDb = AnimalDatabase(applicationContext, "animals", 1)

        lvAnimals.adapter = AnimalTypeAdapter(
            applicationContext,
            R.layout.list_item_animal_type,
            AnimalType.values().map{it.toString()}
        )
    }
}
