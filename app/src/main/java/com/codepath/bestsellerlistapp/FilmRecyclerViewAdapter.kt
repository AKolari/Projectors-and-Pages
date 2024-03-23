package com.codepath.bestsellerlistapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.bestsellerlistapp.R.id
import org.w3c.dom.Text

/**
 * [RecyclerView.Adapter] that can display a [Film]
 */
class FilmRecyclerViewAdapter(
    private val films: List<Film>,
    //private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<FilmRecyclerViewAdapter.FilmViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_film, parent, false)
        return FilmViewHolder(view)
    }

    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class FilmViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Film? = null

        val mFilmTitle: TextView = mView.findViewById<View>(id.film_title) as TextView

        val mFilmImage:ImageView =mView.findViewById<ImageView>(id.film_image)
        //val mFilmDescrition: TextView = mView.findViewById<View>(id.film_description) as TextView


        override fun toString(): String {
            return mFilmTitle.toString()
        }
    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = films[position]

        holder.mItem = film

        holder.mFilmTitle.text = film.title

        //holder.mFilmDescrition.text = film.description



        Glide.with(holder.mView).load("https://image.tmdb.org/t/p/w500/"+film.imageURL).centerInside().into(holder.mFilmImage)


        holder.mView.setOnClickListener {
            holder.mItem?.let { film ->
                //Toast.makeText(it.context, "test: " + holder.mItem?.title, Toast.LENGTH_LONG).show()
                val intent = Intent(it.context, FilmDetailActivity::class.java)
                intent.putExtra("FILM_EXTRA", film)
                it.context.startActivity(intent)

            }
        }
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return films.size
    }
}