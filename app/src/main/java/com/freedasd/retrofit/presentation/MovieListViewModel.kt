package com.freedasd.retrofit.presentation

import androidx.lifecycle.*
import com.freedasd.retrofit.domain.Interactor
import com.freedasd.retrofit.domain.mappers.MovieListDomainToUiMapper
import com.freedasd.retrofit.presentation.mappers.BaseMovieDomainToUiMapper
import com.freedasd.retrofit.presentation.models.MovieUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(
    private val interactor: Interactor,
    private val render: MovieListRender,
    private val uiListMapper: MovieListDomainToUiMapper,
    private val uiMapper: BaseMovieDomainToUiMapper
) : ViewModel() {

    private val selectedItemLD = MutableLiveData<MovieUi>()

    fun list() {
        render.mapList(listOf(MovieUi.Loading))
        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.fetchMovieList().map(uiListMapper)
            withContext(Dispatchers.Main){
                list.map(render)
            }
        }
    }

    fun observeList(owner: LifecycleOwner, observer: Observer<List<MovieUi>>) {
        render.observeList(owner, observer)
    }

    fun fetchMovieById(itemId: Long) {
        viewModelScope.launch {
            val item = interactor.fetchMovieById(itemId)
            selectedItemLD.value = item.map(uiMapper)
        }
    }

    fun observeSelectedItem(owner: LifecycleOwner, observer: Observer<MovieUi>) {
        selectedItemLD.observe(owner, observer)
    }
}