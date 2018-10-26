package com.example.axrorxoja.demoauthapp.model.repository

import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.extension.await
import com.example.axrorxoja.demoauthapp.widget.SingleLiveEvent
import kotlinx.coroutines.experimental.Job
import retrofit2.Call
import timber.log.Timber

/*
* Created by axrorxoja on 10/2/18
*/
abstract class BaseRepositoryImpl<T> : IBaseRepository {
    abstract var job: Job?
    abstract val liveData: SingleLiveEvent<T>

    protected suspend fun <T> parseData(call: Call<T>): BaseData<T> {
        return try {
            val res = call.await()
            Timber.d("$res")
            BaseData(res)
        } catch (e: Exception) {
            e.printStackTrace()
            BaseData(null, null)
        }
    }

    override fun cancelAll() {
        job?.cancel()
        liveData.call()
    }
}