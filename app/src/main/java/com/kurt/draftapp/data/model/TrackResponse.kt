package com.kurt.draftapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TrackResponse(
    val results: ArrayList<Track>,
    val resultCount: Int
) : Serializable