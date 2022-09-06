package com.freedasd.retrofit.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.freedasd.retrofit.presentation.models.MovieUi

interface MovieListRender {

    fun mapList(list: List<MovieUi>)

    fun observeList(owner: LifecycleOwner, observer: Observer<List<MovieUi>>)

    class Base : MovieListRender {

        private val listLiveData = MutableLiveData<List<MovieUi>>()

        override fun mapList(list: List<MovieUi>) {
            listLiveData.value = list
        }

        override fun observeList(owner: LifecycleOwner, observer: Observer<List<MovieUi>>) {
            listLiveData.observe(owner, observer)
        }
    }
}
