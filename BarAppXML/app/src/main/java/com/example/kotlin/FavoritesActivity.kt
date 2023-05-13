package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.model.duplicatedDrinks
import com.example.kotlin.model.favoriteDrinks
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var bottomNavigationHandler: BottomNavigationHandler
    private lateinit var infoText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        // Return arrow
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        //Navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.favorites_screen
        bottomNavigationHandler = BottomNavigationHandler(this, bottomNavigationView)
        bottomNavigationHandler.setupNavigationListener()

        //RecyclerView
        recyclerView = findViewById(R.id.favorites_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        if (favoriteDrinks.isEmpty()) infoText.text = "You have no favorite drinks added"
        else showList()
    }

    private fun showList() {
        val customAdapter = CustomAdapter(favoriteDrinks)
        recyclerView.adapter = customAdapter
    }


}