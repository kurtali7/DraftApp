package com.kurt.draftapp.data.respository

import com.kurt.draftapp.api.ApiService
import com.kurt.draftapp.data.model.TrackResponse
import com.kurt.draftapp.utilities.*
import retrofit2.Response
import javax.inject.Inject

class TrackRepository @Inject constructor(
    private val apiService: ApiService,
    private val prefs: Prefs
) {
    suspend fun searchTrack(): Response<TrackResponse>{
        val term:String = prefs.getTerm()?: DEFAULT_TERM
        val media:String = prefs.getMediaType()?:DEFAULT_MEDIA_TYPE
        return apiService.searchTrack(term, DEFAULT_COUNTRY_CODE, media, DEFAULT_LANG_CODE);
    }
}