package com.freedasd.retrofit.data.mappers

import com.freedasd.retrofit.data.local.DbToDataMapper
import com.freedasd.retrofit.data.models.MovieData

class BaseDbToDataMapper : DbToDataMapper {
    override fun map(
        id: Long,
        title: String,
        imageUrl: String?,
        description: String?,
        publication_date: String?,
        byLine: String?
    ) = MovieData.Base(id, title, imageUrl, description, publication_date, byLine)
}