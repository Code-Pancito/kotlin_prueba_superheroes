package com.example.kotlin_prueba_superhroes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_prueba_superhroes.R
import com.example.kotlin_prueba_superhroes.model.db.SuperheroEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_superhero_stats.*


private const val ARG_SUPERHERO_IMAGE = "image"
private const val ARG_SUPERHERO_NAME = "name"
private const val ARG_SUPERHERO_INTELLIGENCE = "intelligence"
private const val ARG_SUPERHERO_STRENGTH = "strength"
private const val ARG_SUPERHERO_SPEED = "speed"
private const val ARG_SUPERHERO_DURABILITY = "durability"
private const val ARG_SUPERHERO_POWER = "power"
private const val ARG_SUPERHERO_COMBAT = "combat"

/**
 * A simple [Fragment] subclass.
 * Use the [SuperheroStatsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuperheroStatsFragment : Fragment() {
    private var name: String? = null
    private var images: Array<String>? = null
    private var intelligence: String? = null
    private var strength: String? = null
    private var speed: String? = null
    private var durability: String? = null
    private var power: String? = null
    private var combat: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_SUPERHERO_NAME)
            images = it.getStringArray(ARG_SUPERHERO_IMAGE)
            intelligence = it.getString(ARG_SUPERHERO_INTELLIGENCE)
            strength = it.getString(ARG_SUPERHERO_STRENGTH)
            speed = it.getString(ARG_SUPERHERO_SPEED)
            durability = it.getString(ARG_SUPERHERO_DURABILITY)
            power = it.getString(ARG_SUPERHERO_POWER)
            combat = it.getString(ARG_SUPERHERO_COMBAT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_superhero_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for(i in 0..3) {
            if(!images?.get(i).isNullOrBlank()) {
                Picasso.get().load(images?.get(i)).into(imageView_SuperheroStats_Image)
                break
            }
        }
        textView_SuperheroStats_Name.text = name
        textView_SuperheroStats_Intelligence.text = String.format(textView_SuperheroStats_Intelligence.text.toString(), intelligence)
        textView_SuperheroStats_Strength.text = String.format(textView_SuperheroStats_Strength.text.toString(), strength)
        textView_SuperheroStats_Speed.text = String.format(textView_SuperheroStats_Speed.text.toString(), speed)
        textView_SuperheroStats_Durability.text = String.format(textView_SuperheroStats_Durability.text.toString(), durability)
        textView_SuperheroStats_Power.text = String.format(textView_SuperheroStats_Power.text.toString(), power)
        textView_SuperheroStats_Combat.text = String.format(textView_SuperheroStats_Combat.text.toString(), combat)

    }

    companion object {
        @JvmStatic
        fun newInstance(superhero: SuperheroEntity) =
            SuperheroStatsFragment().apply {
                arguments = Bundle().apply {
                    putStringArray(ARG_SUPERHERO_IMAGE, arrayOf(superhero.images.lg, superhero.images.md, superhero.images.sm, superhero.images.xs))
                    putString(ARG_SUPERHERO_NAME, superhero.name)
                    putString(ARG_SUPERHERO_INTELLIGENCE, superhero.powerStats.intelligence.toString())
                    putString(ARG_SUPERHERO_COMBAT, superhero.powerStats.combat.toString())
                    putString(ARG_SUPERHERO_DURABILITY, superhero.powerStats.durability.toString())
                    putString(ARG_SUPERHERO_POWER, superhero.powerStats.power.toString())
                    putString(ARG_SUPERHERO_SPEED, superhero.powerStats.speed.toString())
                    putString(ARG_SUPERHERO_STRENGTH, superhero.powerStats.strength.toString())

                }
            }
    }
}