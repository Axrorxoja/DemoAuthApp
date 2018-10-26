package com.example.axrorxoja.demoauthapp.model.repository.signIn

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.common.SingleLiveEvent
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.signIn.SignInRequest
import com.example.axrorxoja.demoauthapp.entity.signIn.SignInResponse
import com.example.axrorxoja.demoauthapp.model.repository.BaseRepositoryImpl
import com.example.axrorxoja.demoauthapp.model.repository.global.ApiService
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

/*
* Created by axrorxoja on 10/2/18
*/
class SignInRepositoryImpl(private val service: ApiService) :
    BaseRepositoryImpl<BaseData<SignInResponse>>(),
    ISignInRepository {

    override val liveData: SingleLiveEvent<BaseData<SignInResponse>> by lazy { SingleLiveEvent<BaseData<SignInResponse>>() }
    override var job: Job? = null

    override fun signIn(request: SignInRequest): LiveData<BaseData<SignInResponse>> {
        job = GlobalScope.launch(Dispatchers.Default) {
            val baseData = parseData(service.signIn(request))
            liveData.postValue(baseData)
        }
        return liveData
    }

}