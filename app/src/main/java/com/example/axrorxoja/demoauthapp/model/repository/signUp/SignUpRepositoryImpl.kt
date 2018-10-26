package com.example.axrorxoja.demoauthapp.model.repository.signUp

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.signUp.SignUpRequest
import com.example.axrorxoja.demoauthapp.entity.signUp.SignUpResponse
import com.example.axrorxoja.demoauthapp.model.repository.ApiService
import com.example.axrorxoja.demoauthapp.model.repository.BaseRepositoryImpl
import com.example.axrorxoja.demoauthapp.widget.SingleLiveEvent
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

/*
* Created by axrorxoja on 10/2/18
*/
class SignUpRepositoryImpl(private val service: ApiService) :
    BaseRepositoryImpl<BaseData<SignUpResponse>>(),
    ISignUpRepository {
    override val liveData: SingleLiveEvent<BaseData<SignUpResponse>> by lazy { SingleLiveEvent<BaseData<SignUpResponse>>() }
    override var job: Job? = null

    override fun signUp(request: SignUpRequest): LiveData<BaseData<SignUpResponse>> {
        job = GlobalScope.launch(Dispatchers.Default) {
            val baseData = parseData(service.signUp(request))
            liveData.postValue(baseData)
        }
        return liveData
    }

}