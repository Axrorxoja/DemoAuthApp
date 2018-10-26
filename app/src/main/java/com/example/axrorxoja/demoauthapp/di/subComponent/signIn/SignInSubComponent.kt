package com.example.axrorxoja.demoauthapp.di.subComponent.signIn

import com.example.axrorxoja.demoauthapp.di.module.fragment.signIn.SignInFragmentModule
import com.example.axrorxoja.demoauthapp.di.scope.signIn.SignInFragmentScope
import com.example.axrorxoja.demoauthapp.ui.fragments.SignInFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/*
* Created by axrorxoja on 9/26/18
*/
@SignInFragmentScope
@Subcomponent(modules = [SignInFragmentModule::class])
interface SignInSubComponent : AndroidInjector<SignInFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SignInFragment>()
}
