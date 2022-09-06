package com.freedasd.retrofit.data.remote.retrofit

import com.freedasd.retrofit.data.models.MovieData
import com.freedasd.retrofit.data.models.MovieListData

interface CloudToDataMapper {

    fun map(cloud: MovieCloud, id: Long) : MovieData
}