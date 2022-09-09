package com.freedasd.retrofit.data.mappers

import com.freedasd.retrofit.data.local.MovieDb

class BaseDataToDbMapper : DataToDbMapper {

    override fun map(
        id: Long,
        title: String?,
        imageUrl: String?,
        description: String?,
        publication_date: String?,
        byLine: String?
    ) = MovieDb(id, title!!, imageUrl, description, publication_date, byLine)
}
