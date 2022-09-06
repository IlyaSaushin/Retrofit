package com.freedasd.retrofit.domain.mappers

import com.freedasd.retrofit.data.mappers.MovieDataToDomainMapper
import com.freedasd.retrofit.domain.models.MovieDomain

class BaseMovieDataToDomainMapper : MovieDataToDomainMapper<MovieDomain> {

    override fun map(
        id: Long,
        title: String,
        imageUrl: String?,
        description: String?,
        publication_date: String?,
        byLine: String?
    ) = MovieDomain.Base(id, title, imageUrl, description, publication_date, byLine)
}