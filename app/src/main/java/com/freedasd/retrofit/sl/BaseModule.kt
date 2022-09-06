package com.freedasd.retrofit.sl

import androidx.lifecycle.ViewModel

interface BaseModule<V: ViewModel> {

    fun viewModel() : V
}