package com.example.axrorxoja.demoauthapp.di.module.fragment.reset

import com.example.axrorxoja.demoauthapp.di.scope.reset.ResetFragmentScope
import com.example.axrorxoja.demoauthapp.model.repository.ApiService
import com.example.axrorxoja.demoauthapp.model.repository.reset.IResetRepository
import com.example.axrorxoja.demoauthapp.model.repository.reset.ResetRepositoryImpl
import com.example.axrorxoja.demoauthapp.model.storage.IPreference
import com.example.axrorxoja.demoauthapp.presentation.reset.IPresenterReset
import com.example.axrorxoja.demoauthapp.presentation.reset.IViewReset
import com.example.axrorxoja.demoauthapp.presentation.reset.ResetPresenterImpl
import com.example.axrorxoja.demoauthapp.ui.fragments.ResetFragment
import com.example.axrorxoja.demoauthapp.widget.connectionManager.IConnectionManager
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

    @Provides
    @ResetFragmentScope
    fun provideView(fragment: ResetFragment): IViewReset = fragment

    @Provides
    @ResetFragmentScope
    fun providePresenter(
        repo: IResetRepository,
        pref: IPreference,
        view: IViewReset,
        connection: IConnectionManager
    ): IPresenterReset =
        ResetPresenterImpl(repo, connection, view, pref)

}