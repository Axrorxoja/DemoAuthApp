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
abstract class BaseRepositoryImpl<T> :
    IBaseRepository {

    abstract var job: Job?
    abstract val liveData: SingleLiveEvent<BaseData<T>>

    protected suspend fun parseData(call: Call<BaseData<T>>): BaseData<T> {
        return try {
            val res = call.await()
            Timber.d("$res")
            return res
        } catch (e: Exception) {
            e.printStackTrace()
            BaseData()
        }
    }

    override fun cancelAll() {
        job?.cancel()
        liveData.call()
    }
}