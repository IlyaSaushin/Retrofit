package com.freedasd.retrofit.data.models

import com.freedasd.retrofit.data.mappers.MovieListDataToDomainMapper
import com.freedasd.retrofit.domain.models.MovieListDomain

sealed class MovieListData {

    abstract fun map(mapper: MovieListDataToDomainMapper) : MovieListDomain

    data class Success(private val list: List<MovieData>) : MovieListData() {
        override fun map(mapper: MovieListDataToDomainMapper): MovieListDomain = mapper.map(list)
    }

    data class Fail(private val e: Exception) : MovieListData() {
        override fun map(mapper: MovieListDataToDomainMapper): MovieListDomain = mapper.map(e)
    }
}