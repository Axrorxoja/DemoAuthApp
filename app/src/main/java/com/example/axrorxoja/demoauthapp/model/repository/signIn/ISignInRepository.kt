package com.example.axrorxoja.demoauthapp.model.repository.signIn

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.signIn.SignInRequest
import com.example.axrorxoja.demoauthapp.entity.signIn.SignInResponse
import com.example.axrorxoja.demoauthapp.model.repository.IBaseRepository

/*
* Created by axrorxoja on 10/26/18
*/
interface ISignInRepository : IBaseRepository {

    fun signIn(request: SignInRequest): LiveData<BaseData<SignInResponse>>
}