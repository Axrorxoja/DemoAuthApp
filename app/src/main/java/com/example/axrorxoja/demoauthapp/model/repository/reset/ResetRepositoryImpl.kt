package com.example.axrorxoja.demoauthapp.model.repository.reset

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.common.SingleLiveEvent
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordRequest
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordResponse
import com.example.axrorxoja.demoauthapp.model.repository.BaseRepositoryImpl
import com.example.axrorxoja.demoauthapp.model.repository.global.ApiService
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class ResetRepositoryImpl(private val service: ApiService) :
    BaseRepositoryImpl<BaseData<ResetPasswordResponse>>(),
    IResetRepository {

    override var job: Job? = null
    override val liveData: SingleLiveEvent<BaseData<ResetPasswordResponse>> by lazy { SingleLiveEvent<BaseData<ResetPasswordResponse>>() }

    override fun reset(request: ResetPasswordRequest): LiveData<BaseData<ResetPasswordResponse>> {
        job = GlobalScope.launch {
            val baseData = parseData(service.reset(request))
            liveData.postValue(baseData)
        }
        return liveData
    }
}