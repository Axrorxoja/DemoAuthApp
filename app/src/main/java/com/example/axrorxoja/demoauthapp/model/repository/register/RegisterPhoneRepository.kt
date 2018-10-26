package com.example.axrorxoja.demoauthapp.model.repository.register

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.register.RegisterPhoneRequest
import com.example.axrorxoja.demoauthapp.entity.register.RegisterPhoneResponse
import com.example.axrorxoja.demoauthapp.extension.lazyFast
import com.example.axrorxoja.demoauthapp.model.repository.BaseRepositoryImpl
import com.example.axrorxoja.demoauthapp.model.repository.global.ApiService
import com.example.axrorxoja.demoauthapp.widget.SingleLiveEvent
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

/*
* Created by axrorxoja on 10/2/18
*/
class RegisterPhoneRepository(private val service: ApiService)
    : BaseRepositoryImpl<BaseData<RegisterPhoneResponse>>(), IRegisterPhoneRepository {

    override var job: Job? = null
    override val liveData by lazyFast { SingleLiveEvent<BaseData<RegisterPhoneResponse>>() }

    override fun smsRequest(request: RegisterPhoneRequest): LiveData<BaseData<RegisterPhoneResponse>> {
        job = GlobalScope.launch(Dispatchers.Default) {
            val baseData: BaseData<RegisterPhoneResponse> = parseData(service.smsRequest(request))
            liveData.postValue(baseData)
        }
        return liveData
    }
}