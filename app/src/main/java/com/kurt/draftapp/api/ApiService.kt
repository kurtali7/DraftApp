package com.kurt.draftapp.api

import com.kurt.draftapp.data.model.TrackResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/search")
    suspend fun searchTrack(
        @Query("term") term: String,
        @Query("country") country: String,
        @Query("media") media: String,
        @Query("lang") lang: String
    ): Response<TrackResponse>

    /*
    @GET("content-hub/contents/{contentId}")
    suspend fun getContentDetail(
        @Path("contentId") contentId: String
    ): Response<ContentDetailResponse>

    */
}