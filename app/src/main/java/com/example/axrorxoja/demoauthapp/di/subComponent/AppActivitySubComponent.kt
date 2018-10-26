package com.example.axrorxoja.demoauthapp.di.subComponent

import com.example.axrorxoja.demoauthapp.di.module.activity.AppActivityModule
import com.example.axrorxoja.demoauthapp.di.module.activity.FragmentModule
import com.example.axrorxoja.demoauthapp.di.scope.AppActivityScope
import com.example.axrorxoja.demoauthapp.ui.AppActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/*
* Created by axrorxoja on 9/26/18
*/
@AppActivityScope
@Subcomponent(modules = [
    AppActivityModule::class,
    FragmentModule::class])
interface AppActivitySubComponent : AndroidInjector<AppActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<AppActivity>()
}
