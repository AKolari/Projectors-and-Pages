package com.codepath.bestsellerlistapp

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide

class FilmDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detail)

        val film = intent.getSerializableExtra("FILM_EXTRA") as Film

        val bannerView = findViewById<ImageView>(R.id.film_image)
        val titleView = findViewById<TextView>(R.id.film_title)
        val descriptionView = findViewById<TextView>(R.id.film_description)
        val dateView = findViewById<TextView>(R.id.filmReleaseDate)

        Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+film.backdropURL).centerInside().into(bannerView)

        titleView.text=film.title
        descriptionView.text=film.description
        dateView.text="Released on: "+film.releaseDate


    }
}