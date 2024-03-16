package com.codepath.bestsellerlistapp

import FilmFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codepath.bestsellerlistapp.R.id

/**
 * The MainActivity for the BestSellerList app.
 * Launches a [FilmFragment].
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.content, FilmFragment(), null).commit()
    }
}