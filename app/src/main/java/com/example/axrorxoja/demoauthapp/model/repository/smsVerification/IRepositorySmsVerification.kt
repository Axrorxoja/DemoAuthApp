package com.example.axrorxoja.demoauthapp.model.repository.smsVerification

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.smsVerify.SmsVerificationRequest
import com.example.axrorxoja.demoauthapp.entity.smsVerify.SmsVerifyResponse
import com.example.axrorxoja.demoauthapp.model.repository.IBaseRepository

/*
* Created by axrorxoja on 10/2/18
*/
interface IRepositorySmsVerification : IBaseRepository {

    fun verifySms(req: SmsVerificationRequest): LiveData<BaseData<SmsVerifyResponse>>
}