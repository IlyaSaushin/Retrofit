package com.freedasd.retrofit.data.mappers

import com.freedasd.retrofit.data.models.MovieData

interface DbToDataMapper {

    fun map(
        id: Long,
        title: String,
        imageUrl: String?,
        description: String?,
        publication_date: String?,
        byLine: String?
    ) : MovieData
}