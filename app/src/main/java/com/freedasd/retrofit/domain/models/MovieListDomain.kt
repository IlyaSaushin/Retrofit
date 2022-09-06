package com.freedasd.retrofit.domain.models

import com.freedasd.retrofit.core.ErrorType
import com.freedasd.retrofit.domain.mappers.MovieListDomainToUiMapper
import com.freedasd.retrofit.presentation.models.MovieListUi

sealed class MovieListDomain {

    abstract fun map(mapper: MovieListDomainToUiMapper) : MovieListUi

    data class Success(private val list: List<MovieDomain>) : MovieListDomain() {
        override fun map(mapper: MovieListDomainToUiMapper): MovieListUi = mapper.map(list)
    }

    data class Fail(private val errorType: ErrorType) : MovieListDomain() {
        override fun map(mapper: MovieListDomainToUiMapper): MovieListUi = mapper.map(errorType)
    }
}