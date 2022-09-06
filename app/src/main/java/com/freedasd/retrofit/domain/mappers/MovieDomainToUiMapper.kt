package com.freedasd.retrofit.domain.mappers

interface MovieDomainToUiMapper<T> {

    fun map(
        id: Long,
        title: String,
        imageUrl: String?,
        description: String?,
        publication_date: String?,
        byLine: String?
    ) : T
}
