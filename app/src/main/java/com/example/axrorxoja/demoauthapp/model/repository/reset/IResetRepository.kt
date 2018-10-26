package com.example.axrorxoja.demoauthapp.model.repository.reset

import android.arch.lifecycle.LiveData
import com.example.axrorxoja.demoauthapp.entity.BaseData
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordRequest
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordResponse
import com.example.axrorxoja.demoauthapp.model.repository.IBaseRepository

/*
* Created by axrorxoja on 10/26/18
*/
interface IResetRepository : IBaseRepository {

    fun reset(request: ResetPasswordRequest): LiveData<BaseData<ResetPasswordResponse>>
}