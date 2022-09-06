package com.freedasd.retrofit.data

import com.freedasd.retrofit.data.models.MovieData
import com.freedasd.retrofit.data.models.MovieListData
import com.freedasd.retrofit.data.remote.RemoteDataSource
import com.freedasd.retrofit.data.remote.retrofit.CloudToDataMapper
import com.freedasd.retrofit.domain.Repository

class BaseRepository(
    private val remoteDataSource: RemoteDataSource,
    private val cloudToDataMapper: CloudToDataMapper
) : Repository {

    override suspend fun fetchMovieList() : MovieListData = try {
        val cloudList = remoteDataSource.fetchMovieList()
        val dataList = mutableListOf<MovieData>()
        for (i in cloudList) {
            dataList += i.mapToData(cloudToDataMapper, cloudList.indexOf(i).toLong())
        }
        MovieListData.Success(dataList)
    } catch(e: Exception) {
        MovieListData.Fail(e)
    }
}