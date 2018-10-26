package com.example.axrorxoja.demoauthapp.di.module.app

import android.content.Context
import android.net.ConnectivityManager
import com.example.axrorxoja.demoauthapp.App
import com.example.axrorxoja.demoauthapp.di.scope.AppScope
import com.example.axrorxoja.demoauthapp.model.storage.IPreference
import com.example.axrorxoja.demoauthapp.model.storage.PreferenceImpl
import com.example.axrorxoja.demoauthapp.widget.connectionManager.ConnectionManagerImpl
import com.example.axrorxoja.demoauthapp.widget.connectionManager.IConnectionManager
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 9/27/18
*/
@Module
class AppModule {
    @AppScope
    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @AppScope
    @Provides
    fun providesPreferenceStorage(context: Context): IPreference = PreferenceImpl(context)


    @AppScope
    @Provides
    fun provideConnectionService(context: Context): IConnectionManager {
        val it = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return ConnectionManagerImpl(it)

    }

}