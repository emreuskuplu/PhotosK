package com.emre.android.photosk

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emre.android.photosk.model.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class MainViewModel : ViewModel() {
    val photosLiveData = MutableLiveData<List<String>>()

    fun fetchPhotoUrls() {
        PhotosRepo.fetchPhotoUrls()
            .enqueue(object : Callback<Photo> {
                override fun onResponse(
                    call: Call<Photo>,
                    response: Response<Photo>
                ) {
                    photosLiveData.value = response.body()?.let { photo ->
                        photo.photos.photo.map { it.photoUrl }
                    }
                }

                override fun onFailure(call: Call<Photo>, t: Throwable) {
                    Log.e(javaClass.simpleName, t.message ?: "Response failed.")
                }
            })

        thread {
            Log.i(javaClass.simpleName, PhotosRepo.fetchPhotoUrls().request().url().toString())
        }
    }
}