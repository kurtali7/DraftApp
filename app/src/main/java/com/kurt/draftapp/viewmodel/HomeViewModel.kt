package com.kurt.draftapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kurt.draftapp.R
import com.kurt.draftapp.base.BaseViewModel
import com.kurt.draftapp.data.model.Track
import com.kurt.draftapp.data.respository.TrackRepository
import com.kurt.draftapp.utilities.Prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val application: Application,
    private val prefs: Prefs,
    private val trackRepository: TrackRepository
) : BaseViewModel() {

    private var trackData = ArrayList<Track>()
    val trackList = MutableLiveData<ArrayList<Track>>()

    var mediaType: String? = prefs.getTerm()
    var term: String? = prefs.getMediaType()

    private fun saveData(){
        prefs.setTerm(term!!)
        prefs.setMediaType(mediaType!!)
    }

    fun searchTrack() {

        saveData()

        if (isScopeActive()) {
            val job = coroutineScope.launch(handler) {
                showProgress()
                val result = trackRepository.searchTrack()
                if (result.isSuccessful) {
                    trackData.clear()
                    trackData.addAll(result.body()!!.results)
                    trackList.value = trackData
                    Log.d("t",""+trackData.size)
                } else {
                    onError(application.getString(R.string.error_message))
                }
                hideProgress()
            }
            invokeJobOnCompletion(job)
        }
    }
}