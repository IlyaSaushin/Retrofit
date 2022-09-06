package com.freedasd.retrofit

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.freedasd.retrofit.data.VMFactoryProvider
import com.freedasd.retrofit.sl.CoreModule
import com.freedasd.retrofit.sl.Dependencies
import com.freedasd.retrofit.sl.ViewModelsFactory

class RetrofitApp : Application(), VMFactoryProvider {

    private lateinit var coreModule: CoreModule

    override fun onCreate() {
        super.onCreate()

        coreModule = CoreModule()
        coreModule.init(this)
    }

    override fun provide(): ViewModelProvider.Factory {
        return ViewModelsFactory(Dependencies.Base(coreModule))
    }

    fun <T: ViewModel> viewModel(modelClass: Class<T>, owner: ViewModelStoreOwner): T {
        return ViewModelProvider(owner, provide())[modelClass]
    }
}