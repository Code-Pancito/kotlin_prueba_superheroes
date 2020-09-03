package com.example.kotlin_prueba_superhroes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin_prueba_superhroes.R
import com.example.kotlin_prueba_superhroes.pojo.for_retrofit.Superhero
import com.example.kotlin_prueba_superhroes.retrofit.RetrofitClient
import com.example.kotlin_prueba_superhroes.retrofit.SuperheroesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadApiData()
    }

    private fun loadApiData() {
        val service = RetrofitClient.retrofitInstance().create(SuperheroesAPI::class.java)
        val call = service.getAllSuperheroes()
        call.enqueue(object : Callback<ArrayList<Superhero>> {
            override fun onResponse(
                call: Call<ArrayList<Superhero>>,
                response: Response<ArrayList<Superhero>>
            ) {
                Log.d("Retrofit", "${response.body()?.get(0)?.name} - ${response.body()?.get(0)?.slug}")
            }

            override fun onFailure(call: Call<ArrayList<Superhero>>, t: Throwable) {
                Log.d("Retrofit", "COULDN'T CONNECT TO API")
            }
        })
    }
}