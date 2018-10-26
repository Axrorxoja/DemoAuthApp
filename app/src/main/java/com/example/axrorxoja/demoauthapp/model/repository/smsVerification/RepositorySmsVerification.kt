package com.example.axrorxoja.demoauthapp.model.repository.smsVerification

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.smsVerify.SmsVerificationRequest
import com.example.axrorxoja.demoauthapp.entity.smsVerify.SmsVerifyResponse
import com.example.axrorxoja.demoauthapp.extension.lazyFast
import com.example.axrorxoja.demoauthapp.model.repository.BaseRepositoryImpl
import com.example.axrorxoja.demoauthapp.model.repository.global.ApiService
import com.example.axrorxoja.demoauthapp.widget.SingleLiveEvent
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import timber.log.Timber

/*
* Created by axrorxoja on 10/2/18
*/
class RepositorySmsVerification(private val service: ApiService)
    : BaseRepositoryImpl<BaseData<SmsVerifyResponse>>(),
        IRepositorySmsVerification {

    override var job: Job? = null
    override val liveData by lazyFast { SingleLiveEvent<BaseData<SmsVerifyResponse>>() }

    override fun verifySms(req: SmsVerificationRequest): LiveData<BaseData<SmsVerifyResponse>> {
        job = GlobalScope.launch(Dispatchers.Default) {
            Timber.d("verifySms")
            val baseData = parseData(service.verifySms(req))
            liveData.postValue(baseData)
        }
        return liveData
    }
}