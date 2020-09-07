package com.example.kotlin_prueba_superhroes.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.kotlin_prueba_superhroes.model.db.SuperheroEntity
import com.example.kotlin_prueba_superhroes.model.db.SuperheroesDatabase
import com.example.kotlin_prueba_superhroes.model.pojo.for_retrofit.Superhero
import com.example.kotlin_prueba_superhroes.model.retrofit.RetrofitClient
import com.example.kotlin_prueba_superhroes.model.retrofit.SuperheroesAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class SuperheroesRepository(context: Context) {

    private val db: SuperheroesDatabase = SuperheroesDatabase.getDatabase(context)
    private val superheroesList = db.superheroesDAO().getAllSuperheroes()

        fun getSuperheroesList() : LiveData<List<SuperheroEntity>> {
            return superheroesList
        }

        fun fetchDataFromServer() {
            val service = RetrofitClient.retrofitInstance().create(SuperheroesAPI::class.java)
            val call = service.getAllSuperheroes()
            call.enqueue(object : Callback<ArrayList<Superhero>> {
                override fun onResponse(
                    call: Call<ArrayList<Superhero>>,
                    response: Response<ArrayList<Superhero>>
                ) {
                    val superheroesList = mutableListOf<SuperheroEntity>()
                    response.body()?.forEach {
                        superheroesList.add(SuperheroEntity(id = it.id, name = it.name, powerStats = it.powerStats, images = it.images))
                    }

                    CoroutineScope(Dispatchers.IO).launch {
                        db.superheroesDAO().insertSuperheroes(superheroesList)
                    }

                }

                override fun onFailure(call: Call<ArrayList<Superhero>>, t: Throwable) {
                    Log.d("Retrofit", "COULDN'T CONNECT TO API")
                }
            })
        }


}