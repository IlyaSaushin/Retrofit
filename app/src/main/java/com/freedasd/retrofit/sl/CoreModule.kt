package com.freedasd.retrofit.sl

import android.content.Context
import com.freedasd.retrofit.data.BaseRepository
import com.freedasd.retrofit.data.remote.RemoteDataSource
import com.freedasd.retrofit.data.mappers.BaseCloudToDataMapper
import com.freedasd.retrofit.data.remote.retrofit.RetrofitClient
import com.freedasd.retrofit.domain.Interactor
import com.freedasd.retrofit.domain.mappers.BaseMovieDataToDomainMapper
import com.freedasd.retrofit.domain.mappers.BaseMovieListDataToDomainMapper

class CoreModule {

    lateinit var interactor: Interactor

    fun init(context: Context) {
        val service = RetrofitClient.buildService()
        val remoteDataSource = RemoteDataSource.Base(service)
        val cloudToDataMapper = BaseCloudToDataMapper()
        val repository = BaseRepository(remoteDataSource, cloudToDataMapper)
        val mapperToDomain = BaseMovieDataToDomainMapper()
        val listDataToDomainMapper = BaseMovieListDataToDomainMapper(mapperToDomain)
        interactor = Interactor.Base(repository, listDataToDomainMapper)
    }
}