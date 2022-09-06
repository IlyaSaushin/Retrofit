package com.freedasd.retrofit.data.mappers

import com.freedasd.retrofit.data.models.MovieData
import com.freedasd.retrofit.domain.models.MovieListDomain

interface MovieListDataToDomainMapper {

    fun map(list: List<MovieData>) : MovieListDomain

    fun map(e: Exception) : MovieListDomain
}