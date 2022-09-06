package com.freedasd.retrofit.presentation.mappers

import com.freedasd.retrofit.core.ErrorType
import com.freedasd.retrofit.domain.mappers.MovieDomainToUiMapper
import com.freedasd.retrofit.domain.models.MovieDomain
import com.freedasd.retrofit.domain.mappers.MovieListDomainToUiMapper
import com.freedasd.retrofit.presentation.models.MovieListUi
import com.freedasd.retrofit.presentation.models.MovieUi

class BaseMovieListDomainToUiMapper(
    private val toUiMapper: MovieDomainToUiMapper<MovieUi>
) : MovieListDomainToUiMapper {

    override fun map(list: List<MovieDomain>) = MovieListUi.Success(list, toUiMapper)

    override fun map(errorType: ErrorType) = MovieListUi.Fail(errorType)
}