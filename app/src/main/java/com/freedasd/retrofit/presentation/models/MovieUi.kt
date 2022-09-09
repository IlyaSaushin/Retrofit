package com.freedasd.retrofit.presentation.models

import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.freedasd.retrofit.core.Same
import kotlinx.parcelize.Parcelize

interface MovieUi : Same<MovieUi> {

    override fun same(item: MovieUi): Boolean = false

    fun map(movieTitle: TextView, image: ImageView, publication: TextView) = Unit

    fun mapError(errorField: TextView) = Unit

    fun id() : Long = 0

    fun mapDetails(
        name: TextView,
        image: ImageView,
        desc: TextView,
        publ_date: TextView,
        firstLine: TextView
    ) = Unit

    object Loading : MovieUi

    data class Fail(private val error: String) : MovieUi {
        fun map(errorField: TextView) {
            errorField.error = error
        }
    }

    @Parcelize
    class Base(
        private val id: Long,
        private val title: String,
        private val imageUrl: String?,
        private val description: String?,
        private val publication_date: String?,
        private val byLine: String?,
        ) : MovieUi, Parcelable {

        override fun map(movieTitle: TextView, image: ImageView, publication: TextView) {
            movieTitle.text = title
            publication.text = publication_date
            Glide.with(image).load(imageUrl).into(image)
        }

        override fun mapDetails(
            name: TextView,
            image: ImageView,
            desc: TextView,
            publ_date: TextView,
            firstLine: TextView
        ) {
            name.text = title
            desc.text = description
            publ_date.text = publication_date
            firstLine.text = byLine
            Glide.with(image).load(imageUrl).into(image)
        }

        override fun id(): Long = id
    }
}