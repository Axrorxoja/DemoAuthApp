package com.example.axrorxoja.demoauthapp.di.module.app

import android.app.Activity
import com.example.axrorxoja.demoauthapp.di.subComponent.AppActivitySubComponent
import com.example.axrorxoja.demoauthapp.ui.AppActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/*
* Created by axrorxoja on 9/26/18
*/

@Module(
    subcomponents = [
        AppActivitySubComponent::class]
)
abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(AppActivity::class)
    abstract fun bindActivity(builder: AppActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}
