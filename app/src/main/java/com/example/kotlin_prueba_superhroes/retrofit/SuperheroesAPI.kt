package com.example.kotlin_prueba_superhroes.retrofit

import com.example.kotlin_prueba_superhroes.pojo.for_retrofit.Superhero
import retrofit2.Call
import retrofit2.http.GET

interface SuperheroesAPI {
    @GET("all.json")
    fun getAllSuperheroes(): Call<ArrayList<Superhero>>
}