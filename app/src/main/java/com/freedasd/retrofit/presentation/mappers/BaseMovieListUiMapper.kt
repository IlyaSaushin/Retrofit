package com.freedasd.retrofit.presentation.mappers

import com.freedasd.retrofit.core.ErrorType
import com.freedasd.retrofit.domain.mappers.MovieDomainToUiMapper
import com.freedasd.retrofit.domain.models.MovieDomain
import com.freedasd.retrofit.presentation.models.MovieListUi
import com.freedasd.retrofit.presentation.models.MovieUi

class BaseMovieListUiMapper(
    private val toUiMapper: MovieDomainToUiMapper<MovieUi>,
) : MovieListUiMapper {

    override fun map(list: List<MovieDomain>) = MovieListUi.Success(list, toUiMapper)

    override fun map(errorType: ErrorType) = MovieListUi.Fail(errorType)
}