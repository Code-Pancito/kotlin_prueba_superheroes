package com.example.kotlin_prueba_superhroes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlin_prueba_superhroes.model.SuperheroesRepository
import com.example.kotlin_prueba_superhroes.model.db.SuperheroEntity

class SuperHeroesViewModel(application: Application): AndroidViewModel(application) {

    private val repository = SuperheroesRepository(application)
    private val superheroesList = repository.getSuperheroesList()

    fun fetchDataFromServer() {
        repository.fetchDataFromServer()
    }

    fun getAllSuperheroes(): LiveData<List<SuperheroEntity>> {
        return superheroesList
    }

}