package com.freedasd.retrofit.domain

import com.freedasd.retrofit.data.models.MovieListData

interface Repository {

    suspend fun fetchMovieList() : MovieListData
}