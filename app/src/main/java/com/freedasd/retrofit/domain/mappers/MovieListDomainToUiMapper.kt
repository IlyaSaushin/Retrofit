package com.freedasd.retrofit.domain.mappers

import com.freedasd.retrofit.core.ErrorType
import com.freedasd.retrofit.domain.models.MovieDomain
import com.freedasd.retrofit.presentation.models.MovieListUi

interface MovieListDomainToUiMapper {

    fun map(list: List<MovieDomain>) : MovieListUi

    fun map(errorType: ErrorType) : MovieListUi
}