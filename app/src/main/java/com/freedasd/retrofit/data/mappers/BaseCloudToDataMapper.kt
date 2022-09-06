package com.freedasd.retrofit.data.mappers

import com.freedasd.retrofit.data.models.MovieData
import com.freedasd.retrofit.data.remote.retrofit.CloudToDataMapper
import com.freedasd.retrofit.data.remote.retrofit.MovieCloud

class BaseCloudToDataMapper : CloudToDataMapper {

    override fun map(cloud: MovieCloud, id: Long): MovieData {
        return MovieData.Base(
                id,
                cloud.title.toString(),
                cloud.multimedia?.imageUrl.toString(),
                cloud.description?.toString(),
                cloud.date?.toString(),
                cloud.byLine?.toString()
            )
    }
}