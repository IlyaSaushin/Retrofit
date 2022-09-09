package com.freedasd.retrofit.data.mappers

import com.freedasd.retrofit.data.local.MovieDb

interface DataToDbMapper {

    fun map(
        id: Long,
        title: String?,
        imageUrl: String?,
        description: String?,
        publication_date: String?,
        byLine: String?
    ) : MovieDb
}
