package com.example.kotlin_prueba_superhroes.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin_prueba_superhroes.pojo.Appearance
import com.example.kotlin_prueba_superhroes.pojo.PowerStats

@Entity(tableName = "superheroes_list")
data class SuperheroEntity(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                           val name: String,
                           val slug: String,
                           @Embedded val powerStats: PowerStats,
                           @Embedded val appearance: Appearance,
)