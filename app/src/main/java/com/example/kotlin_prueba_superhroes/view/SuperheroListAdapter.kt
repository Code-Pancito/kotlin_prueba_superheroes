package com.example.kotlin_prueba_superhroes.view


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_prueba_superhroes.R
import com.example.kotlin_prueba_superhroes.model.db.SuperheroEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_superhero.view.*

class SuperheroListAdapter(private var superheroesDataSet: List<SuperheroEntity>, val onItemClickListener: OnItemClickListener):
    RecyclerView.Adapter<SuperheroListAdapter.SuperheroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_superhero, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return superheroesDataSet.size
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position:Int) {
        val post = superheroesDataSet[position]
        val imageList = listOf(post.images.lg, post.images.md, post.images.sm, post.images.xs)

        holder.superheroName.text = post.name
        for(i in 0..3) {
            if(!imageList[i].isNullOrBlank()) {
                Picasso.get().load(imageList[i]).into(holder.superheroImage)
                break
            }

        }

    }

    fun updateDataSet(newDataSet: List<SuperheroEntity>) {
        superheroesDataSet = newDataSet
        notifyDataSetChanged()
    }

    inner class SuperheroViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var superheroName: TextView = itemView.textView_SuperheroName
        var superheroImage: ImageView = itemView.imageView_SuperheroImage
        var view = itemView.setOnClickListener(this)
        override fun onClick(p0: View?) {
            onItemClickListener.onItemClick(superheroesDataSet[adapterPosition])
        }
    }

    interface OnItemClickListener {
        fun onItemClick(data: SuperheroEntity)
    }

}
