package com.codepath.bestsellerlistapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.bestsellerlistapp.R.id

/**
 * [RecyclerView.Adapter] that can display a [BestSellerBook]
 */
class BestSellerBooksRecyclerViewAdapter(
    private val books: List<BestSellerBook>
    )
    : RecyclerView.Adapter<BestSellerBooksRecyclerViewAdapter.BookViewHolder>()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_best_seller_book, parent, false)
        return BookViewHolder(view)
    }
        var expanded = false
    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class BookViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        var mItem: BestSellerBook? = null
        //val mBookRank = mView.findViewById<TextView>(id.ranking)
        val mBookTitle: TextView = mView.findViewById<View>(id.book_title) as TextView
        val mBookAuthor: TextView = mView.findViewById<View>(id.book_author) as TextView
        val mBookImage:ImageView =mView.findViewById<ImageView>(id.book_image)
        val mBookDescrition: TextView = mView.findViewById<View>(id.book_description) as TextView
        val mBookAmazon = mView.findViewById<Button>(id.buy_button);

        override fun toString(): String {
            return mBookTitle.toString() + " '" + mBookAuthor.text + "'"
        }
    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]

        holder.mItem = book
        //holder.mBookRank.text = book.rank.toString()
        holder.mBookTitle.text = book.title
        holder.mBookAuthor.text = book.author
        holder.mBookDescrition.text = book.description

        holder.mBookDescrition.setOnClickListener{
            if(expanded){
                expanded=false
                //holder.mBookDescrition.maxEms=5
                holder.mBookAmazon.isInvisible=true
                holder.mBookDescrition.maxLines = 3

            }
            else{
                expanded=true
                holder.mBookAmazon.isVisible=true
                holder.mBookDescrition.maxLines = 10


            }
        }

        holder.mBookAmazon.setOnClickListener{

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(book.amazonUrl))
            startActivity(it.context, browserIntent, null)
        }


        Glide.with(holder.mView).load(book.imageURL).centerInside().into(holder.mBookImage)


        holder.mView.setOnClickListener {
            holder.mItem?.let {
                //Toast.makeText( it.context, "test: " + item.title, Toast.LENGTH_LONG).show()
            }
        }
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return books.size
    }
}