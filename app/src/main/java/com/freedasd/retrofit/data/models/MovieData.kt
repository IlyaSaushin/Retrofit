package com.freedasd.retrofit.data.models

import com.freedasd.retrofit.data.mappers.MovieDataToDomainMapper

interface MovieData {

    fun <T> map(mapper: MovieDataToDomainMapper<T>) : T

    fun id() : Long

    class Base(
        private val id: Long,
        private val title: String,
        private val imageUrl: String?,
        private val description: String?,
        private val publication_date: String?,
        private val byLine: String?,
    ) : MovieData {

        override fun <T> map(mapper: MovieDataToDomainMapper<T>) = mapper.map(
            id,
            title,
            imageUrl,
            description,
            publication_date,
            byLine
        )

        override fun id(): Long = id
    }
}