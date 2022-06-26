package com.kurt.draftapp.utilities

import android.content.Context
import android.content.SharedPreferences

const val PREFS_NAME = "UserPrefsFile"

open class SharedPreferencesHelper(context: Context) {

    private val userPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)
    private val editor: SharedPreferences.Editor = userPreferences.edit()

    fun setBooleanValue(key: String, status: Boolean) {
        editor.putBoolean(key, status)
        editor.commit()
    }

    fun getBooleanValue(key: String) = userPreferences.getBoolean(key, false)

    fun setStringValue(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getStringValue(key: String) = userPreferences.getString(key, null)

    fun setIntValue(key: String, value: Int) {
        editor.putInt(key, value)
        editor.commit()
    }

    fun getIntValue(key: String) = userPreferences.getInt(key, 0)

    fun removeStringValue(key: String) {
        editor.remove(key)
        editor.commit()
    }
}