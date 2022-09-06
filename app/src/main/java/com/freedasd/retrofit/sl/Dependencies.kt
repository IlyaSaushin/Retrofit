package com.freedasd.retrofit.sl

interface Dependencies {

    fun module(feature: Feature) : BaseModule<*>

    class Base(private val coreModule: CoreModule) : Dependencies {
        override fun module(feature: Feature): BaseModule<*> {
            return when(feature) {
                Feature.MOVIE_LIST -> MovieListModule(coreModule)
            }
        }
    }
}