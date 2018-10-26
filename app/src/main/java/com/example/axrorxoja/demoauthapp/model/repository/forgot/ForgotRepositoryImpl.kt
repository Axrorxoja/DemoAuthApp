package com.example.axrorxoja.demoauthapp.model.repository.forgot

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.common.SingleLiveEvent
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.forgot.ForgotRequest
import com.example.axrorxoja.demoauthapp.entity.forgot.ForgotResponse
import com.example.axrorxoja.demoauthapp.model.repository.BaseRepositoryImpl
import com.example.axrorxoja.demoauthapp.model.repository.global.ApiService
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class ForgotRepositoryImpl(private val service: ApiService) :
    BaseRepositoryImpl<BaseData<ForgotResponse>>(), IForgotRepository {

    override var job: Job? = null
    override val liveData: SingleLiveEvent<BaseData<ForgotResponse>> by lazy { SingleLiveEvent<BaseData<ForgotResponse>>() }

    override fun forgot(request: ForgotRequest): LiveData<BaseData<ForgotResponse>> {
        job = GlobalScope.launch {
            val data = parseData(service.forgot(request))
            liveData.postValue(data)
        }
        return liveData
    }
}