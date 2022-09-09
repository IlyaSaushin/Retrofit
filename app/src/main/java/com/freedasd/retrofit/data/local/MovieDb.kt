package com.freedasd.retrofit.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.freedasd.retrofit.data.models.MovieData

@Entity(
    tableName = "MovieDataBase"
)
data class MovieDb (
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val title: String,
    val imageUrl: String?,
    val description: String?,
    val publication_date: String?,
    val byLine: String?,
) {
    fun map() = MovieData.Base(id, title, imageUrl, description, publication_date, byLine)
}