package com.freedasd.retrofit.domain

import com.freedasd.retrofit.data.models.MovieData
import com.freedasd.retrofit.data.models.MovieListData

interface Repository {

    suspend fun fetchMovieList() : MovieListData

    suspend fun fetchMovieById(itemId: Long) : MovieData
}