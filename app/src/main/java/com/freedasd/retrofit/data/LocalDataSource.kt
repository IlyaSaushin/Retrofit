package com.freedasd.retrofit.data

import com.freedasd.retrofit.data.local.AppDataBase
import com.freedasd.retrofit.data.local.MovieDb
import com.freedasd.retrofit.data.mappers.DataToDbMapper
import com.freedasd.retrofit.data.models.MovieData

interface LocalDataSource {

    suspend fun insert(list: List<MovieData>)

    suspend fun fetchList() : List<MovieDb>

    suspend fun fetchById(itemId: Long) : MovieData

    class Base(
        private val appDb: AppDataBase,
        private val mapper: DataToDbMapper
    ) : LocalDataSource {

        override suspend fun insert(list: List<MovieData>) = appDb.dao().insertList(list.map { it.mapToDb(mapper) })

        override suspend fun fetchList() = appDb.dao().fetchList()

        override suspend fun fetchById(itemId: Long) = appDb.dao().fetchMovieById(itemId).map()
    }
}