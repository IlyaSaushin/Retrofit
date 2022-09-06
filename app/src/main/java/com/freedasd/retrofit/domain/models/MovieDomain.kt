package com.freedasd.retrofit.domain.models

import com.freedasd.retrofit.domain.mappers.MovieDomainToUiMapper

interface MovieDomain {

    fun <T> map(mapper: MovieDomainToUiMapper<T>) : T

    class Base(
        private val id: Long,
        private val title: String,
        private val imageUrl: String?,
        private val description: String?,
        private val publication_date: String?,
        private val byLine: String?,
        ) : MovieDomain {
        override fun <T> map(mapper: MovieDomainToUiMapper<T>) = mapper.map(
            id,
            title,
            imageUrl,
            description,
            publication_date,
            byLine
        )
    }
}