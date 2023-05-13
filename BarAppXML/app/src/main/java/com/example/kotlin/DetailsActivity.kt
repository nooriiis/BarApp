package com.example.kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlin.model.duplicatedDrinks
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailsActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var bottomNavigationHandler: BottomNavigationHandler
    private lateinit var imageView: ImageView
    private lateinit var nameView: TextView
    private lateinit var categoryView: TextView
    private lateinit var flavorView: TextView
    private lateinit var ingredientsView: TextView
    private lateinit var instructionsView: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Return arrow
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //Navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.home_screen
        bottomNavigationHandler = BottomNavigationHandler(this, bottomNavigationView)
        bottomNavigationHandler.setupNavigationListener()

        //View
        imageView = findViewById(R.id.drink_icon_detail)
        nameView = findViewById(R.id.drink_name)
        categoryView = findViewById(R.id.drink_name_category)
        flavorView = findViewById(R.id.drink_flavor)
        ingredientsView = findViewById(R.id.drink_ingredients)
        instructionsView = findViewById(R.id.drink_instructions)

        //View Text
        val myIntent = intent
        val drinkId = myIntent.getIntExtra("drinkId", 0)
        imageView.setImageResource(duplicatedDrinks[drinkId-1].imageRes)
        nameView.text = duplicatedDrinks[drinkId-1].name
        categoryView.text = "Category: ${duplicatedDrinks[drinkId-1].category.name}"
        flavorView.text = duplicatedDrinks[drinkId-1].flavorProfile
        ingredientsView.text = duplicatedDrinks[drinkId-1].ingredients
        instructionsView.text = duplicatedDrinks[drinkId-1].instructions
    }
}