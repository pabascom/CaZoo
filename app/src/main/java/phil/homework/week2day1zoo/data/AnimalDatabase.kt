package phil.homework.week2day1zoo.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import phil.homework.week2day1zoo.Animal

class AnimalDatabase(context: Context, name: String, version: Int) : SQLiteOpenHelper(context, name, null, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(AnimalContract.Query.SQL_CREATE_ENTRIES)
        val animalList = Animal.getAnimals(30);
        animalList.map {
            val values = ContentValues().apply {
                put(AnimalContract.FeedEntry.COLUMN_NAME, it.name)
                put(AnimalContract.FeedEntry.COLUMN_TYPE, it.type)
                put(AnimalContract.FeedEntry.COLUMN_SPECIES, it.species)
                put(AnimalContract.FeedEntry.COLUMN_WEIGHT, it.weight)
            }
            db?.insert(AnimalContract.FeedEntry.TABLE_NAME, null, values)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun saveAnimal(animal: Animal) {

        val contentValue = ContentValues()

        contentValue.put(AnimalContract.FeedEntry.COLUMN_NAME, animal.name)
        contentValue.put(AnimalContract.FeedEntry.COLUMN_TYPE, animal.type)
        contentValue.put(AnimalContract.FeedEntry.COLUMN_SPECIES, animal.species)
        contentValue.put(AnimalContract.FeedEntry.COLUMN_WEIGHT, animal.weight)

        writableDatabase.insert(AnimalContract.FeedEntry.TABLE_NAME, null, contentValue)
        writableDatabase.close()
    }

    fun getAllAnimals(): List<Animal> {

        val animalList = ArrayList<Animal>()
        writableDatabase.rawQuery(AnimalContract.Query.SQL_GET_ANIMALS, null)
            .apply {
                if (moveToFirst()) {
                    do {
                        animalList.add(
                            Animal(
                                getString(getColumnIndex(AnimalContract.FeedEntry.COLUMN_NAME)),
                                getString(getColumnIndex(AnimalContract.FeedEntry.COLUMN_TYPE)),
                                getString(getColumnIndex(AnimalContract.FeedEntry.COLUMN_SPECIES)),
                                getInt(getColumnIndex(AnimalContract.FeedEntry.COLUMN_WEIGHT))
                            )
                        )
                    } while (moveToNext())
                } else {
                    return emptyList()
                }
            }
        return animalList
    }

    fun getAnimalsByType(type: AnimalType): List<Animal> {
        val typeString = type.toString()
        val animalList = ArrayList<Animal>()
        writableDatabase.rawQuery(AnimalContract.Query.SQL_GET_ANIMALS, null)
            .apply {
                if (moveToFirst()) {
                    do {
                        Animal(
                            getString(getColumnIndex(AnimalContract.FeedEntry.COLUMN_NAME)),
                            getString(getColumnIndex(AnimalContract.FeedEntry.COLUMN_TYPE)),
                            getString(getColumnIndex(AnimalContract.FeedEntry.COLUMN_SPECIES)),
                            getInt(getColumnIndex(AnimalContract.FeedEntry.COLUMN_WEIGHT))
                        ).apply{
                            if(this.type == typeString) animalList.add(this)
                        }
                    } while (moveToNext())
                } else {
                    return emptyList()
                }
            }
        return animalList
    }

}