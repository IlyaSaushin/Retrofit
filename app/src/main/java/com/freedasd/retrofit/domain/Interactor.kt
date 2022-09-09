package com.freedasd.retrofit.domain

import com.freedasd.retrofit.data.mappers.MovieListDataToDomainMapper
import com.freedasd.retrofit.domain.mappers.BaseMovieDataToDomainMapper
import com.freedasd.retrofit.domain.models.MovieDomain
import com.freedasd.retrofit.domain.models.MovieListDomain

interface Interactor {

    suspend fun fetchMovieList() : MovieListDomain

    suspend fun fetchMovieById(itemId: Long) : MovieDomain

    class Base(
        private val repository: Repository,
        private val listDataToDomainMapper: MovieListDataToDomainMapper,
        private val dataToDomainMapper: BaseMovieDataToDomainMapper
    ) : Interactor {

        override suspend fun fetchMovieList() = repository.fetchMovieList().map(listDataToDomainMapper)

        override suspend fun fetchMovieById(itemId: Long) = repository.fetchMovieById(itemId).map(dataToDomainMapper)
    }
}