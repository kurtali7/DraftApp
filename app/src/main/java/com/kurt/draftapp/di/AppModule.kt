package com.kurt.draftapp.di

import android.app.Application
import com.kurt.draftapp.utilities.Prefs
import com.kurt.draftapp.utilities.SharedPreferencesHelper
import com.kurt.draftapp.utilities.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUtils() = Utils()

    @Provides
    @Singleton
    fun provideSharedPreference(application: Application) =
        SharedPreferencesHelper(application)

    @Provides
    @Singleton
    fun providePref(sharedPreferencesHelper: SharedPreferencesHelper) =
        Prefs(sharedPreferencesHelper)

}