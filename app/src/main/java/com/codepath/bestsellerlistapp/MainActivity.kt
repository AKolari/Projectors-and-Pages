package com.codepath.bestsellerlistapp

import FilmFragment
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContentInfo
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout
import com.codepath.bestsellerlistapp.R.id

/**
 * The MainActivity for the BestSellerList app.
 * Launches a [FilmFragment].
 */
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myView = findViewById<ConstraintLayout>(R.id.main)



        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, FilmFragment(), null).commit()
        val toProjectors = findViewById<Button>(R.id.toProjectors);
        val toPages = findViewById<Button>(R.id.toPages);

        toProjectors.isEnabled=false
        toPages.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);




        toProjectors.setOnClickListener{
            val newFragmentTransaction = supportFragmentManager.beginTransaction()
            newFragmentTransaction.replace(R.id.content, FilmFragment(), null).commit()
            toProjectors.isEnabled=false
            toPages.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            toPages.isEnabled=true
            toProjectors.getBackground().setColorFilter(null);
            myView.setBackgroundColor(getColor(R.color.red))

        }




        toPages.setOnClickListener{

            val newFragmentTransaction = supportFragmentManager.beginTransaction()
            newFragmentTransaction.replace(R.id.content, BestSellerBooksFragment(), null).commit()
            toProjectors.isEnabled=true
            toPages.isEnabled=false
            toProjectors.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            toPages.getBackground().setColorFilter(null);
            myView.setBackgroundColor(getColor(R.color.blue))
        }


    }
}