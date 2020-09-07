package com.example.kotlin_prueba_superhroes.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperheroesDAO {
    @Query("SELECT * FROM superheroes_list")
    fun getAllSuperheroes(): LiveData<List<SuperheroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperheroes(superheroes: List<SuperheroEntity>)
}