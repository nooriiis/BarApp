package com.example.kotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class AddSuggestionActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var bottomNavigationHandler: BottomNavigationHandler
    private lateinit var nameView: EditText
    private lateinit var flavorView: EditText
    private lateinit var ingredientsView: EditText
    private lateinit var instructionsView: EditText
    private lateinit var categorySpinner: Spinner
    private lateinit var spinnerString: String
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_suggestion)

        // Return arrow
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        //Navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.add_suggestion_screen
        bottomNavigationHandler = BottomNavigationHandler(this, bottomNavigationView)
        bottomNavigationHandler.setupNavigationListener()

        //View
        nameView = findViewById(R.id.suggestion_nameInput)
        flavorView = findViewById(R.id.suggestion_flavorInput)
        ingredientsView = findViewById(R.id.suggestion_ingredientsInput)
        instructionsView = findViewById(R.id.suggestion_instructionsInput)
        button = findViewById(R.id.suggestion_button)
        button.setOnClickListener { listener() }

        //Spinner
        categorySpinner = findViewById(R.id.suggestion_categoryEdit)
        val nrEventsAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_drinks, android.R.layout.simple_spinner_item)
        nrEventsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = nrEventsAdapter
        categorySpinner.onItemSelectedListener = this
    }

    private fun listener() {
        Toast.makeText(this, "Drink Added!", Toast.LENGTH_SHORT).show()
        nameView.text = null
        flavorView.text = null
        ingredientsView.text = null
        instructionsView.text = null
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        spinnerString = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}