package com.example.kotlin_prueba_superhroes.model.retrofit

import com.example.kotlin_prueba_superhroes.model.pojo.for_retrofit.Superhero
import retrofit2.Call
import retrofit2.http.GET

interface SuperheroesAPI {
    @GET("all.json")
    fun getAllSuperheroes(): Call<ArrayList<Superhero>>
}