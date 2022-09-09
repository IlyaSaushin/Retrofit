package com.freedasd.retrofit.sl

import com.freedasd.retrofit.presentation.MovieDetailsViewModel

class MovieDetailsModule(private val coreModule: CoreModule) : BaseModule<MovieDetailsViewModel> {

    override fun viewModel(): MovieDetailsViewModel {
        return MovieDetailsViewModel()
    }
}