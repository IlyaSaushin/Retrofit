package com.freedasd.retrofit.sl

import android.content.Context
import com.freedasd.retrofit.data.BaseRepository
import com.freedasd.retrofit.data.LocalDataSource
import com.freedasd.retrofit.data.local.AppDataBase
import com.freedasd.retrofit.data.RemoteDataSource
import com.freedasd.retrofit.data.mappers.BaseCloudToDataMapper
import com.freedasd.retrofit.data.mappers.BaseDataToDbMapper
import com.freedasd.retrofit.data.mappers.DataToDbMapper
import com.freedasd.retrofit.data.remote.retrofit.RetrofitClient
import com.freedasd.retrofit.domain.Interactor
import com.freedasd.retrofit.domain.mappers.BaseMovieDataToDomainMapper
import com.freedasd.retrofit.domain.mappers.BaseMovieListDataToDomainMapper

class CoreModule {

    lateinit var interactor: Interactor

    fun init(context: Context) {

        val database = AppDataBase.localDataBase(context)
        val service = RetrofitClient.buildService()
        val remoteDataSource = RemoteDataSource.Base(service)
        val cloudToDataMapper = BaseCloudToDataMapper()
        val dataToDbMapper = BaseDataToDbMapper()
        val localDataSource = LocalDataSource.Base(database, dataToDbMapper)
        val repository = BaseRepository(remoteDataSource, localDataSource, cloudToDataMapper)
        val mapperToDomain = BaseMovieDataToDomainMapper()
        val listDataToDomainMapper = BaseMovieListDataToDomainMapper(mapperToDomain)
        val dataToDomainMapper = BaseMovieDataToDomainMapper()
        interactor = Interactor.Base(repository, listDataToDomainMapper, dataToDomainMapper)
    }
}