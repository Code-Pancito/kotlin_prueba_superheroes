package com.example.kotlin_prueba_superhroes.pojo.for_retrofit

import com.example.kotlin_prueba_superhroes.pojo.*
import com.google.gson.annotations.SerializedName

data class Superhero(val id: String,
                     val name: String,
                     val slug: String,
                     @SerializedName("powerstats")val powerStats: PowerStats,
                     val appearance: Appearance,
                     val biography: Biography,
                     val work: Work,
                     val connections: Connections,
                     val images: Images
)