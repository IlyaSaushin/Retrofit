package com.freedasd.retrofit.data.mappers

interface MovieDataToDomainMapper <T> {

    fun map(
        id: Long,
        title: String,
        imageUrl: String?,
        description: String?,
        publication_date: String?,
        byLine: String?
    ) : T
}