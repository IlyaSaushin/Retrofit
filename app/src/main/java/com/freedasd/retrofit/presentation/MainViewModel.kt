package com.freedasd.retrofit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freedasd.retrofit.data.remote.retrofit.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
) : ViewModel() {

}
//
////    private val cloudToDataMapper = CloudToDataMapper.Base()
////    private val cloudListMapper = CloudListMapper.Base(cloudToDataMapper)
//
//    fun list() {
//
//        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
//            throwable.printStackTrace()
//        }
//
//        val service = RetrofitClient.buildService()
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = RetrofitClient.movieList()
//            Log.d("tag", "list: $response")
////            Log.d("tag", "list: started get")
////            val response = service.list()
//////            val list = cloudListMapper.map(response)
////            Log.d("tag", "list: $response")
//////            val list = response.list.map { list -> MovieData(list.title) }
//////            val movieList = response.list.map {
//////                if (it.title?.isEmpty() == true) {
//////                    throw IllegalStateException("Nullable title")
//////                } else {
//////                    it.mapToData(CloudToDataMapper.Base())
//////                }
//            }
//
////            withContext(Dispatchers.IO) {
////                textView.text = list.toString()
////            }
//        }
//    }
//
//interface CloudListMapper {
//
//    fun map(list: List<MovieCloud>) : List<MovieData>
//
//    class Base(private val mapper: CloudToDataMapper) : CloudListMapper {
//        override fun map(list: List<MovieCloud>): List<MovieData> = list.map { it.mapToData(mapper) }
//    }
//}
//
////
////interface RemoteDataSource {
////
////    suspend fun fetchList() : List<MovieCloud>
////
////    class Base(private val service: Service) : RemoteDataSource {
////        override suspend fun fetchList() = service.list().list
////    }
////}
