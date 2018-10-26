package com.example.axrorxoja.demoauthapp.di.module.fragment.forgot

import com.example.axrorxoja.demoauthapp.di.scope.forgot.ForgotFragmentScope
import com.example.axrorxoja.demoauthapp.model.repository.forgot.ForgotRepositoryImpl
import com.example.axrorxoja.demoauthapp.model.repository.forgot.IForgotRepository
import com.example.axrorxoja.demoauthapp.model.repository.global.ApiService
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 9/27/18
*/
@Module
class ForgotFragmentModule {

    @Provides
    @ForgotFragmentScope
    fun provideRepository(service: ApiService): IForgotRepository = ForgotRepositoryImpl(service)

}