package com.kurt.draftapp.utilities

class Prefs(private val sharedPreferencesHelper: SharedPreferencesHelper) {

    fun getMediaType() = sharedPreferencesHelper.getStringValue(PREF_KEY_SEARCH_MEDIA_TYPE)?: DEFAULT_MEDIA_TYPE

    fun setMediaType(media: String) {
        sharedPreferencesHelper.setStringValue(PREF_KEY_SEARCH_MEDIA_TYPE, media)
    }

    fun getTerm() = sharedPreferencesHelper.getStringValue(PREF_KEY_SEARCH_TERM)?: DEFAULT_TERM

    fun setTerm(term: String) {
        sharedPreferencesHelper.setStringValue(PREF_KEY_SEARCH_TERM, term)
    }
}