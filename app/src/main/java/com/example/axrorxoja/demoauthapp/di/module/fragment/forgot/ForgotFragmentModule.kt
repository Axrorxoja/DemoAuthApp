package com.example.axrorxoja.demoauthapp.di.module.fragment.forgot

import com.example.axrorxoja.demoauthapp.di.scope.forgot.ForgotFragmentScope
import com.example.axrorxoja.demoauthapp.model.repository.ApiService
import com.example.axrorxoja.demoauthapp.model.repository.forgot.ForgotRepositoryImpl
import com.example.axrorxoja.demoauthapp.model.repository.forgot.IForgotRepository
import com.example.axrorxoja.demoauthapp.model.storage.IPreference
import com.example.axrorxoja.demoauthapp.presentation.forgot.ForgotPresenter
import com.example.axrorxoja.demoauthapp.presentation.forgot.IPresenterForgot
import com.example.axrorxoja.demoauthapp.presentation.forgot.IViewForgot
import com.example.axrorxoja.demoauthapp.ui.fragments.ForgotFragment
import com.example.axrorxoja.demoauthapp.widget.connectionManager.IConnectionManager
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

    @Provides
    @ForgotFragmentScope
    fun providePresenter(
        repo: IForgotRepository,
        pref: IPreference,
        view: IViewForgot,
        connection: IConnectionManager
    ): IPresenterForgot = ForgotPresenter(repo, pref, view, connection)


    @Provides
    @ForgotFragmentScope
    fun provideView(fragment: ForgotFragment): IViewForgot = fragment
}