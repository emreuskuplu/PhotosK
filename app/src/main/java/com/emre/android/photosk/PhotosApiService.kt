package com.emre.android.photosk

import com.emre.android.photosk.model.Photo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosApiService {

    @GET("services/rest/?")
    fun fetchPhotoUrls(
        @Query("api_key") apiKey: String,
        @Query("method") method: String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallback: String,
        @Query("extras") extras: String,
        @Query("per_page") perPage: String
    ) : Call<Photo>
}