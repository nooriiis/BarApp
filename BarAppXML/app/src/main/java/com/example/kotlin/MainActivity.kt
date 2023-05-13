package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.model.Drink
import com.example.kotlin.model.duplicatedDrinks
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var bottomNavigationHandler: BottomNavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Return arrow
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        //Navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.home_screen
        bottomNavigationHandler = BottomNavigationHandler(this, bottomNavigationView)
        bottomNavigationHandler.setupNavigationListener()

        //RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        showList()
    }

    private fun showList() {
        val customAdapter = CustomAdapter(duplicatedDrinks)
        recyclerView.adapter = customAdapter
    }
}