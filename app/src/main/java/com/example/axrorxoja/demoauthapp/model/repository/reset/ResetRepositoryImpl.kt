package com.example.axrorxoja.demoauthapp.model.repository.reset

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordRequest
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordResponse
import com.example.axrorxoja.demoauthapp.model.repository.ApiService
import com.example.axrorxoja.demoauthapp.model.repository.BaseRepositoryImpl
import com.example.axrorxoja.demoauthapp.widget.SingleLiveEvent
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class ResetRepositoryImpl(private val service: ApiService) :
    BaseRepositoryImpl<ResetPasswordResponse>(),
    IResetRepository {

    override var job: Job? = null
    override val liveData by lazy { SingleLiveEvent<BaseData<ResetPasswordResponse>>() }

    override fun reset(request: ResetPasswordRequest): LiveData<BaseData<ResetPasswordResponse>> {
        job = GlobalScope.launch {
            val baseData = parseData(service.reset(request))
            liveData.postValue(baseData)
        }
        return liveData
    }
}