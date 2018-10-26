package com.example.axrorxoja.demoauthapp.di.module.fragment.signIn

import com.example.axrorxoja.demoauthapp.di.scope.signIn.SignInFragmentScope
import com.example.axrorxoja.demoauthapp.model.repository.ApiService
import com.example.axrorxoja.demoauthapp.model.repository.signIn.ISignInRepository
import com.example.axrorxoja.demoauthapp.model.repository.signIn.SignInRepositoryImpl
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 9/27/18
*/
@Module
class SignInFragmentModule {

    @Provides
    @SignInFragmentScope
    fun provideRepository(service: ApiService): ISignInRepository = SignInRepositoryImpl(service)


}