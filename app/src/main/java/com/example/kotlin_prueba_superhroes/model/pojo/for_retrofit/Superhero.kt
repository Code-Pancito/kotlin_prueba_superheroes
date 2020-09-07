package com.example.kotlin_prueba_superhroes.model.pojo.for_retrofit

import com.example.kotlin_prueba_superhroes.model.pojo.*
import com.google.gson.annotations.SerializedName

data class Superhero(val id: Int,
                     val name: String,
                     @SerializedName("powerstats")val powerStats: PowerStats,
                     val images: Images
)