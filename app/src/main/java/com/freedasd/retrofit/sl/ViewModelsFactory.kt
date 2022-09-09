package com.freedasd.retrofit.sl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.freedasd.retrofit.presentation.MovieDetailsViewModel
import com.freedasd.retrofit.presentation.MovieListViewModel

class ViewModelsFactory(private val dependencies: Dependencies) : ViewModelProvider.Factory {

    private val map = HashMap<Class<*>, Feature>().apply {
        put(MovieListViewModel::class.java, Feature.MOVIE_LIST)
        put(MovieDetailsViewModel::class.java, Feature.MOVIE_DETAILS)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val feature = map[modelClass] ?: throw IllegalStateException("unknown modelClass")
        return dependencies.module(feature).viewModel() as T
    }
}