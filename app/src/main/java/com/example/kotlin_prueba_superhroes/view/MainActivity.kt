package com.example.kotlin_prueba_superhroes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_prueba_superhroes.R
import com.example.kotlin_prueba_superhroes.model.db.SuperheroEntity
import com.example.kotlin_prueba_superhroes.model.pojo.for_retrofit.Superhero
import com.example.kotlin_prueba_superhroes.model.retrofit.RetrofitClient
import com.example.kotlin_prueba_superhroes.model.retrofit.SuperheroesAPI
import com.example.kotlin_prueba_superhroes.viewmodel.SuperHeroesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var superHeroesViewModel: SuperHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = SuperheroListAdapter(listOf<SuperheroEntity>())
        recyclerView_SuperheroesList.adapter = adapter
        recyclerView_SuperheroesList.layoutManager = LinearLayoutManager(this)

        superHeroesViewModel = ViewModelProvider(this).get(SuperHeroesViewModel::class.java)

        superHeroesViewModel.fetchDataFromServer()

        superHeroesViewModel.getAllSuperheroes().observe(this, {
            adapter.updateDataSet(it)
        })


    }

}