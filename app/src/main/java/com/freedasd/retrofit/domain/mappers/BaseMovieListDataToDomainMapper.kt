package com.freedasd.retrofit.domain.mappers

import com.freedasd.retrofit.core.ErrorType
import com.freedasd.retrofit.data.models.MovieData
import com.freedasd.retrofit.data.mappers.MovieDataToDomainMapper
import com.freedasd.retrofit.data.mappers.MovieListDataToDomainMapper
import com.freedasd.retrofit.domain.models.MovieDomain
import com.freedasd.retrofit.domain.models.MovieListDomain
import retrofit2.HttpException
import java.net.UnknownHostException

class BaseMovieListDataToDomainMapper(
    private val mapperToDomain: MovieDataToDomainMapper<MovieDomain>
) : MovieListDataToDomainMapper {

    override fun map(list: List<MovieData>) = MovieListDomain.Success(list.map { it.map(mapperToDomain) })

    override fun map(e: Exception) = MovieListDomain.Fail(
        when (e) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_ERROR
        }
    )
}
