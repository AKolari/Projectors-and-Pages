package com.codepath.bestsellerlistapp

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Film: Serializable {


    @JvmField
    @SerializedName("original_title")
    var title: String? = null




    @JvmField
    @SerializedName("poster_path")
    var imageURL: String?=null

    @JvmField
    @SerializedName("backdrop_path")
    var backdropURL: String?=null


    @JvmField
    @SerializedName("overview")
    var description: String?=null

    @JvmField
    @SerializedName("release_date")
    var releaseDate: String?=null


}