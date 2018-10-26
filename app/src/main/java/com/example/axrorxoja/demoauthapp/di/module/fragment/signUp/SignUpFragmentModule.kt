package com.example.axrorxoja.demoauthapp.di.module.fragment.signUp

import com.example.axrorxoja.demoauthapp.di.scope.forgot.ForgotFragmentScope
import com.example.axrorxoja.demoauthapp.di.scope.signUp.SignUpFragmentScope
import com.example.axrorxoja.demoauthapp.model.repository.ApiService
import com.example.axrorxoja.demoauthapp.model.repository.signUp.ISignUpRepository
import com.example.axrorxoja.demoauthapp.model.repository.signUp.SignUpRepositoryImpl
import com.example.axrorxoja.demoauthapp.presentation.signUp.IPresenterSignUp
import com.example.axrorxoja.demoauthapp.presentation.signUp.IViewSignUp
import com.example.axrorxoja.demoauthapp.presentation.signUp.SignUpPresenterImpl
import com.example.axrorxoja.demoauthapp.ui.fragments.SignUpFragment
import com.example.axrorxoja.demoauthapp.widget.connectionManager.IConnectionManager
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

    @Provides
    @ForgotFragmentScope
    fun provideView(fragment: SignUpFragment): IViewSignUp = fragment

    @Provides
    @ForgotFragmentScope
    fun providePresenter(
        repo: ISignUpRepository,
        view: IViewSignUp,
        connection: IConnectionManager
    ): IPresenterSignUp =
        SignUpPresenterImpl(repo, view, connection)

}