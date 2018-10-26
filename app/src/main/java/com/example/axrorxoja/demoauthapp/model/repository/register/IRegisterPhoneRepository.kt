package com.example.axrorxoja.demoauthapp.model.repository.register

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.register.RegisterPhoneRequest
import com.example.axrorxoja.demoauthapp.entity.register.RegisterPhoneResponse
import com.example.axrorxoja.demoauthapp.model.repository.IBaseRepository

/*
* Created by axrorxoja on 10/2/18
*/
interface IRegisterPhoneRepository : IBaseRepository {

    fun smsRequest(request: RegisterPhoneRequest): LiveData<BaseData<RegisterPhoneResponse>>
}