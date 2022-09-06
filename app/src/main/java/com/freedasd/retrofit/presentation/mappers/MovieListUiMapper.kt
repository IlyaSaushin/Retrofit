package com.freedasd.retrofit.presentation.mappers

import com.freedasd.retrofit.core.ErrorType
import com.freedasd.retrofit.domain.models.MovieDomain
import com.freedasd.retrofit.presentation.models.MovieListUi

interface MovieListUiMapper {

    fun map(list: List<MovieDomain>) : MovieListUi

    fun map(errorType: ErrorType) : MovieListUi
}