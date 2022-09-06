package com.freedasd.retrofit.sl

import com.freedasd.retrofit.presentation.MovieListRender
import com.freedasd.retrofit.presentation.MovieListViewModel
import com.freedasd.retrofit.presentation.mappers.BaseMovieDomainToUiMapper
import com.freedasd.retrofit.presentation.mappers.BaseMovieListDomainToUiMapper
import com.freedasd.retrofit.sl.BaseModule
import com.freedasd.retrofit.sl.CoreModule

class MovieListModule(private val coreModule: CoreModule) : BaseModule<MovieListViewModel> {

    override fun viewModel(): MovieListViewModel {
        val render = MovieListRender.Base()
        val interactor = coreModule.interactor
        val toUiMapper = BaseMovieDomainToUiMapper()
        val uiMapper = BaseMovieListDomainToUiMapper(toUiMapper)
        return MovieListViewModel(interactor, render, uiMapper)
    }
}