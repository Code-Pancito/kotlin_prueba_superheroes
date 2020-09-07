package com.example.kotlin_prueba_superhroes.model.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin_prueba_superhroes.model.pojo.Images
import com.example.kotlin_prueba_superhroes.model.pojo.PowerStats

@Entity(tableName = "superheroes_list")
data class SuperheroEntity(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                           val name: String,
                           @Embedded val powerStats: PowerStats,
                           @Embedded val images: Images
)