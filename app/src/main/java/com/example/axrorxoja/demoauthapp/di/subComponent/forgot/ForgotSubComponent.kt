package com.example.axrorxoja.demoauthapp.di.subComponent.forgot

import com.example.axrorxoja.demoauthapp.di.module.fragment.forgot.ForgotFragmentModule
import com.example.axrorxoja.demoauthapp.di.scope.forgot.ForgotFragmentScope
import com.example.axrorxoja.demoauthapp.ui.fragments.ForgotFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/*
* Created by axrorxoja on 9/26/18
*/
@ForgotFragmentScope
@Subcomponent(modules = [ForgotFragmentModule::class])
interface ForgotSubComponent : AndroidInjector<ForgotFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ForgotFragment>()
}
