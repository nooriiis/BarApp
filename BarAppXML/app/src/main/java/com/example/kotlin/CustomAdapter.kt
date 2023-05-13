package com.example.kotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.model.Drink
import com.example.kotlin.model.favoriteDrinks

class CustomAdapter(drinksList: List<Drink>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val drinksList: List<Drink>

    init {
        this.drinksList = drinksList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardTitleView.text = drinksList[position].name
        holder.cardSubtitleView.text = drinksList[position].category.name
        holder.cardImage.setImageResource(drinksList[position].imageRes)

        holder.imageButton.setOnClickListener {
            favoriteDrinks.add(drinksList[position])
            holder.imageButton.setImageResource(R.drawable.baseline_favorite_red_24)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("drinkId", drinksList[position].id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return drinksList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardTitleView: TextView; val cardSubtitleView: TextView; val cardImage: ImageView; val imageButton: ImageButton
        init {
            cardTitleView = itemView.findViewById(R.id.drink_name)
            cardSubtitleView = itemView.findViewById(R.id.drinkCategory)
            cardImage = itemView.findViewById(R.id.drinkIcon)
            imageButton = itemView.findViewById(R.id.cardImageButton)
        }
    }
}