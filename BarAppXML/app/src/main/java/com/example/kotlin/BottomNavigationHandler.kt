package com.example.kotlin

import android.content.Context
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationHandler(private val context: Context, private val bottomNavigationView: BottomNavigationView) {

    fun setupNavigationListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_screen -> {
                    val intent = Intent(context, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    context.startActivity(intent)
                    true
                }
                R.id.favorites_screen -> {
                    val intent = Intent(context, FavoritesActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    context.startActivity(intent)
                    true
                }
                R.id.add_suggestion_screen -> {
                    val intent = Intent(context, AddSuggestionActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    context.startActivity(intent)
                    true
                }
                else -> {false}
            }
        }
    }
}