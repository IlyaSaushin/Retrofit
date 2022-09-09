package com.freedasd.retrofit.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<MovieDb>)

    @Query("select * from Moviedatabase")
    suspend fun fetchList() : List<MovieDb>

    @Query("select * from MovieDataBase where id = :itemId")
    suspend fun fetchMovieById(itemId: Long) : MovieDb
}