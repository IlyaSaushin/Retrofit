package com.freedasd.retrofit.data.remote.retrofit

import com.google.gson.annotations.SerializedName

data class MovieListCloud(
    @SerializedName("status") val status: String,
    @SerializedName("results") val results: List<MovieCloud>
)

data class MovieCloud (
    @SerializedName("display_title")
    val title: String?,
    @SerializedName("multimedia")
    val multimedia: Multimedia?,
    @SerializedName("summary_short")
    val description: String?,
    @SerializedName("publication_date")
    val date: String?,
    @SerializedName("byline")
    val byLine: String?
) {
    fun mapToData(mapper: CloudToDataMapper, id: Long) = mapper.map(this, id)
}

data class Multimedia(
    @SerializedName("src") val imageUrl: String?
)