package com.example.kotlin_prueba_superhroes.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_prueba_superhroes.R
import com.example.kotlin_prueba_superhroes.model.db.SuperheroEntity
import com.example.kotlin_prueba_superhroes.viewmodel.SuperHeroesViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SuperheroListAdapter.OnItemClickListener {

    private lateinit var superHeroesViewModel: SuperHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = SuperheroListAdapter(listOf<SuperheroEntity>(), this)
        recyclerView_SuperheroesList.adapter = adapter
        recyclerView_SuperheroesList.layoutManager = LinearLayoutManager(this)

        superHeroesViewModel = ViewModelProvider(this).get(SuperHeroesViewModel::class.java)

        superHeroesViewModel.fetchDataFromServer()

        superHeroesViewModel.getAllSuperheroes().observe(this, {
            adapter.updateDataSet(it)
        })


    }

    override fun onItemClick(data: SuperheroEntity) {
        superheroStatsIntent(data)
    }

    private fun superheroStatsIntent(superhero: SuperheroEntity) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_SuperheroStats, SuperheroStatsFragment.newInstance(superhero), "SUPERHERO_STATS")
            .addToBackStack(null)
            .commit()
    }

}