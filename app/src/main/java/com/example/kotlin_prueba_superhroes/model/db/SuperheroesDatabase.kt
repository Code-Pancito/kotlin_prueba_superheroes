package com.example.kotlin_prueba_superhroes.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SuperheroEntity::class], version = 1, exportSchema = false)
abstract class SuperheroesDatabase : RoomDatabase() {

    abstract fun superheroesDAO() : SuperheroesDAO

    companion object {
        @Volatile
        private var INSTANCE: SuperheroesDatabase? = null

        fun getDatabase(context: Context): SuperheroesDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SuperheroesDatabase::class.java,
                    "superheroes_database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}