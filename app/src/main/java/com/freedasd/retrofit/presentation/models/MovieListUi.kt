package com.freedasd.retrofit.presentation.models

import android.util.Log
import com.freedasd.retrofit.R
import com.freedasd.retrofit.core.ErrorType
import com.freedasd.retrofit.domain.mappers.MovieDomainToUiMapper
import com.freedasd.retrofit.domain.models.MovieDomain
import com.freedasd.retrofit.presentation.MovieListRender

sealed class MovieListUi() {

    abstract fun map(render: MovieListRender)

    data class Success(
        private val list: List<MovieDomain>,
        private val toUiMapper: MovieDomainToUiMapper<MovieUi>
    ) : MovieListUi() {
        override fun map(render: MovieListRender) {
            val listUi = list.map { it.map(toUiMapper) }
            render.mapList(listUi)
            Log.d("tag", "map: $listUi")
        }
    }

    data class Fail(
        private val errorType: ErrorType
    ) : MovieListUi() {
        override fun map(render: MovieListRender) {
            val id = when (errorType) {
                ErrorType.NO_CONNECTION -> R.string.no_connection
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
                ErrorType.GENERIC_ERROR -> R.string.unknown_error
            }
        }
    }
}