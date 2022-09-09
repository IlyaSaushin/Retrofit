package com.freedasd.retrofit.data

import com.freedasd.retrofit.data.remote.retrofit.MovieCloud
import com.freedasd.retrofit.data.remote.retrofit.Service

interface RemoteDataSource {

    suspend fun fetchMovieList() : List<MovieCloud>

    class Base(
        private val service: Service
    ) : RemoteDataSource {
        override suspend fun fetchMovieList() = service.list().results
    }
}