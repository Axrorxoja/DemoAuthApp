package com.example.axrorxoja.demoauthapp.model.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.axrorxoja.demoauthapp.model.storage.preferenceDataTypes.BooleanPreference

/*
* Created by axrorxoja on 9/26/18
*/
private const val IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH"

class PreferenceImpl(context: Context) : IPreference {


    private val pref: SharedPreferences

    init {
        pref = context.applicationContext.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
//        pref = PreferenceManager.getDefaultSharedPreferences(context)
    }

    override var isFirstLaunch: Boolean by BooleanPreference(pref, IS_FIRST_LAUNCH, true)

}