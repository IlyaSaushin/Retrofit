package com.freedasd.retrofit.data

import androidx.lifecycle.ViewModelProvider
import com.freedasd.retrofit.sl.ViewModelsFactory

interface VMFactoryProvider {

    fun provide() : ViewModelProvider.Factory
}