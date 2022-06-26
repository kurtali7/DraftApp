package com.kurt.draftapp.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel() {
    val isProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val alertMessage = MutableLiveData<String>()

    private var coroutineContext = SupervisorJob() + Dispatchers.Main
    var coroutineScope = CoroutineScope(coroutineContext)

    var handler = CoroutineExceptionHandler { _coroutineContext, throwable ->
        Log.d("TAG", throwable.toString())
    }

    fun onAlertMessage(message: String) {
        alertMessage.value = message
    }

    fun onError(message: String) {
        errorMessage.value = message
    }

    fun showProgress() {
        isProgress.value = true
    }

    fun hideProgress() {
        isProgress.value = false
    }

    fun isScopeActive(): Boolean {
        return coroutineScope.isActive
    }

    fun invokeJobOnCompletion(job: Job) {
        job.invokeOnCompletion {
            if (it != null) {
                it.localizedMessage?.let { localizeMsg ->
                    Log.d("TAG", localizeMsg)
                }
            }
            job.cancel()
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }

}