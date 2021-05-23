package com.emre.android.photosk

import com.emre.android.photosk.model.Photo
import retrofit2.Call

object PhotosRepo {
    private const val API_KEY = "550be48f323d48b91745061ffea60a24"
    private const val METHOD = "flickr.photos.getRecent"
    private const val FORMAT = "json"
    private const val EXTRAS = "url_m"
    private const val PER_PAGE = "100"

    fun fetchPhotoUrls(): Call<Photo> {
        return PhotosRetrofit.photosApiService
            .fetchPhotoUrls(
                API_KEY,
                METHOD,
                FORMAT,
                "1",
                EXTRAS,
                PER_PAGE
            )
    }
}