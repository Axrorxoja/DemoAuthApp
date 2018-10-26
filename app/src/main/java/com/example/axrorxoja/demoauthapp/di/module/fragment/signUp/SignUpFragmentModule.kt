package com.example.axrorxoja.demoauthapp.di.module.fragment.signUp

import com.example.axrorxoja.demoauthapp.di.scope.signUp.SignUpFragmentScope
import com.example.axrorxoja.demoauthapp.model.repository.ApiService
import com.example.axrorxoja.demoauthapp.model.repository.signUp.ISignUpRepository
import com.example.axrorxoja.demoauthapp.model.repository.signUp.SignUpRepositoryImpl
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 9/27/18
*/
@Module
class SignUpFragmentModule {

    @Provides
    @SignUpFragmentScope
    fun provideRepository(service: ApiService): ISignUpRepository = SignUpRepositoryImpl(service)


}