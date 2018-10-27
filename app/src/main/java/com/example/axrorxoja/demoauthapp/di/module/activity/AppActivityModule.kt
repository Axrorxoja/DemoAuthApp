package com.example.axrorxoja.demoauthapp.di.module.activity

import com.example.axrorxoja.demoauthapp.di.scope.AppActivityScope
import com.example.axrorxoja.demoauthapp.presentation.IViewActivity
import com.example.axrorxoja.demoauthapp.ui.AppActivity
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 9/27/18
*/
@Module
class AppActivityModule {

    @AppActivityScope
    @Provides
    fun providesPresenter(activity: AppActivity): IViewActivity = activity

}