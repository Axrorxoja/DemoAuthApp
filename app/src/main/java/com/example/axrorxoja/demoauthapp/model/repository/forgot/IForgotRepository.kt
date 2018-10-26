package com.example.axrorxoja.demoauthapp.model.repository.forgot

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.forgot.ForgotRequest
import com.example.axrorxoja.demoauthapp.entity.forgot.ForgotResponse
import com.example.axrorxoja.demoauthapp.model.repository.IBaseRepository

/*
* Created by axrorxoja on 10/26/18
*/
interface IForgotRepository : IBaseRepository {

    fun forgot(request: ForgotRequest): LiveData<BaseData<ForgotResponse>>
}