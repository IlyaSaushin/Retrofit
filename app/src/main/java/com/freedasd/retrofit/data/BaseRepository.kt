package com.freedasd.retrofit.data

import android.util.Log
import com.freedasd.retrofit.data.models.MovieData
import com.freedasd.retrofit.data.models.MovieListData
import com.freedasd.retrofit.data.remote.retrofit.CloudToDataMapper
import com.freedasd.retrofit.domain.Repository

class BaseRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val cloudToDataMapper: CloudToDataMapper
) : Repository {

    override suspend fun fetchMovieList() : MovieListData = try {

        val localResult = localDataSource.fetchList()
        if (localResult.isEmpty()) {
            val cloudList = remoteDataSource.fetchMovieList()
            val dataList = mutableListOf<MovieData>()
            for (i in cloudList) {
                dataList += i.mapToData(cloudToDataMapper, cloudList.indexOf(i).toLong())
            }
            localDataSource.insert(dataList)
            MovieListData.Success(dataList)
        } else {
            MovieListData.Success(localResult.map { it.map() })
        }
    } catch(e: Exception) {
        MovieListData.Fail(e)
    }

    override suspend fun fetchMovieById(itemId: Long) = localDataSource.fetchById(itemId)
}