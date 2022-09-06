package com.freedasd.retrofit.presentation

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freedasd.retrofit.domain.Interactor
import com.freedasd.retrofit.domain.mappers.MovieListDomainToUiMapper
import com.freedasd.retrofit.presentation.mappers.BaseMovieListUiMapper
import com.freedasd.retrofit.presentation.models.MovieUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(
    private val interactor: Interactor,
    private val render: MovieListRender,
    private val uiMapper: MovieListDomainToUiMapper
) : ViewModel() {

    fun list() {
        render.mapList(listOf(MovieUi.Loading))
        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.fetchMovieList().map(uiMapper)
            Log.d("tag", "viewModel: $list")
            withContext(Dispatchers.Main){
                list.map(render)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<MovieUi>>) {
        render.observeList(owner, observer)
    }
}