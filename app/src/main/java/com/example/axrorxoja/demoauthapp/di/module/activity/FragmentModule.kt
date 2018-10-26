package com.example.axrorxoja.demoauthapp.di.module.activity

import android.support.v4.app.Fragment
import com.example.axrorxoja.demoauthapp.di.subComponent.forgot.ForgotSubComponent
import com.example.axrorxoja.demoauthapp.di.subComponent.reset.ResetSubComponent
import com.example.axrorxoja.demoauthapp.di.subComponent.signIn.SignInSubComponent
import com.example.axrorxoja.demoauthapp.di.subComponent.signUp.SignUpSubComponent
import com.example.axrorxoja.demoauthapp.ui.fragments.ForgotFragment
import com.example.axrorxoja.demoauthapp.ui.fragments.ResetFragment
import com.example.axrorxoja.demoauthapp.ui.fragments.SignInFragment
import com.example.axrorxoja.demoauthapp.ui.fragments.SignUpFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

/*
* Created by axrorxoja on 9/26/18
*/

@Module(
    subcomponents = [
        SignInSubComponent::class,
        SignUpSubComponent::class,
        ResetSubComponent::class,
        ForgotSubComponent::class
    ]
)
abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(ForgotFragment::class)
    abstract fun bindForgot(builder: ForgotSubComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(ResetFragment::class)
    abstract fun bindReset(builder: ResetSubComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(SignInFragment::class)
    abstract fun bindSignIn(builder: SignInSubComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(SignUpFragment::class)
    abstract fun bindSignUp(builder: SignUpSubComponent.Builder): AndroidInjector.Factory<out Fragment>
}
