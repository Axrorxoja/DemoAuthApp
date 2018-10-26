package com.example.axrorxoja.demoauthapp.di.module.fragment.reset

import com.example.axrorxoja.demoauthapp.di.scope.reset.ResetFragmentScope
import com.example.axrorxoja.demoauthapp.model.repository.ApiService
import com.example.axrorxoja.demoauthapp.model.repository.reset.IResetRepository
import com.example.axrorxoja.demoauthapp.model.repository.reset.ResetRepositoryImpl
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 9/27/18
*/
@Module
class ResetFragmentModule {

    @Provides
    @ResetFragmentScope
    fun provideRepository(service: ApiService): IResetRepository = ResetRepositoryImpl(service)


}