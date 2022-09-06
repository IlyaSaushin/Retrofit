package com.freedasd.retrofit.presentation.mappers

import com.freedasd.retrofit.domain.mappers.MovieDomainToUiMapper
import com.freedasd.retrofit.presentation.models.MovieUi

class BaseMovieDomainToUiMapper : MovieDomainToUiMapper<MovieUi> {

    override fun map(
        id: Long,
        title: String,
        imageUrl: String?,
        description: String?,
        publication_date: String?,
        byLine: String?
    ) = MovieUi.Base(id, title, imageUrl, description, publication_date, byLine)
}