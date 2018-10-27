package com.example.axrorxoja.demoauthapp.di.subComponent.signUp

import com.example.axrorxoja.demoauthapp.di.module.fragment.signUp.SignUpFragmentModule
import com.example.axrorxoja.demoauthapp.di.scope.signUp.SignUpFragmentScope
import com.example.axrorxoja.demoauthapp.ui.fragments.SignUpFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/*
* Created by axrorxoja on 9/26/18
*/
@SignUpFragmentScope
@Subcomponent(modules = [SignUpFragmentModule::class])
interface SignUpSubComponent : AndroidInjector<SignUpFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SignUpFragment>()
}
