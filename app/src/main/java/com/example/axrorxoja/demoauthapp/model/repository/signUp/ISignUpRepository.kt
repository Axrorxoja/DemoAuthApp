package com.example.axrorxoja.demoauthapp.model.repository.signUp

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.signUp.SignUpRequest
import com.example.axrorxoja.demoauthapp.entity.signUp.SignUpResponse
import com.example.axrorxoja.demoauthapp.model.repository.IBaseRepository

/*
* Created by axrorxoja on 10/26/18
*/
interface ISignUpRepository : IBaseRepository {

    fun signUp(request: SignUpRequest): LiveData<BaseData<SignUpResponse>>
}