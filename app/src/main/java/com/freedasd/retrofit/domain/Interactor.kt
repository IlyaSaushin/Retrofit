package com.freedasd.retrofit.domain

import com.freedasd.retrofit.data.mappers.MovieListDataToDomainMapper
import com.freedasd.retrofit.domain.models.MovieListDomain

interface Interactor {

    suspend fun fetchMovieList() : MovieListDomain

    class Base(
        private val repository: Repository,
        private val listDataToDomainMapper: MovieListDataToDomainMapper
    ) : Interactor {
        override suspend fun fetchMovieList() = repository.fetchMovieList().map(listDataToDomainMapper)
    }
}