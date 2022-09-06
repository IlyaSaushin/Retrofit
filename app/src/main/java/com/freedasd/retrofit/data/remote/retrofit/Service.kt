package com.freedasd.retrofit.data.remote.retrofit

import com.freedasd.retrofit.domain.models.MovieListDomain
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("/svc/movies/v2/reviews/picks.json?")
    suspend fun list(
        @Query("api-key") apiKey: String = API_KEY,
        @Query("offset") query: Int = DEFAULT_QUERY
    ) : MovieListCloud

    companion object {

        const val API_KEY = "E720gGg3ZRBsnMq9OsWR2XLdixQWQtn3"
        const val DEFAULT_QUERY = 3
    }
}