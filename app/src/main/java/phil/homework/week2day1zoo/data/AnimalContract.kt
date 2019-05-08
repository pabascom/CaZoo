package phil.homework.week2day1zoo.data

import android.provider.BaseColumns

object AnimalContract {

    object FeedEntry : BaseColumns {

        const val TABLE_NAME = "Animal"
        const val COLUMN_NAME = "Name"
        const val COLUMN_TYPE = "Type"
        const val COLUMN_SPECIES = "Species"
        const val COLUMN_WEIGHT = "Weight"
    }

    object Query {

        const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${FeedEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${FeedEntry.COLUMN_NAME} TEXT," +
                    "${FeedEntry.COLUMN_TYPE} TEXT," +
                    "${FeedEntry.COLUMN_SPECIES} TEXT," +
                    "${FeedEntry.COLUMN_WEIGHT} INT)"

        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FeedEntry.TABLE_NAME}"

        const val SQL_GET_ANIMALS = "SELECT * FROM ${FeedEntry.TABLE_NAME}"

    }
}