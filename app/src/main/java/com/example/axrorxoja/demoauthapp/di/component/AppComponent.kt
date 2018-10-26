package com.example.axrorxoja.demoauthapp.di.component

import com.example.axrorxoja.demoauthapp.App
import com.example.axrorxoja.demoauthapp.di.module.app.ActivityModule
import com.example.axrorxoja.demoauthapp.di.module.app.AppModule
import com.example.axrorxoja.demoauthapp.di.module.app.NetModule
import com.example.axrorxoja.demoauthapp.di.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/*
* Created by axrorxoja on 9/26/18
*/
@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}
