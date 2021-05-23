package com.emre.android.photosk.model

import com.squareup.moshi.Json

data class PhotoJson(
    @Json(name = "url_m") val photoUrl: String = ""
)