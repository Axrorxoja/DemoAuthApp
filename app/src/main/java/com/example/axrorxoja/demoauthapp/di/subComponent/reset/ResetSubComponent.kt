package com.example.axrorxoja.demoauthapp.di.subComponent.reset

import com.example.axrorxoja.demoauthapp.di.module.fragment.reset.ResetFragmentModule
import com.example.axrorxoja.demoauthapp.di.scope.reset.ResetFragmentScope
import com.example.axrorxoja.demoauthapp.ui.fragments.ResetFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/*
* Created by axrorxoja on 9/26/18
*/
@ResetFragmentScope
@Subcomponent(modules = [ResetFragmentModule::class])
interface ResetSubComponent : AndroidInjector<ResetFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ResetFragment>()
}
