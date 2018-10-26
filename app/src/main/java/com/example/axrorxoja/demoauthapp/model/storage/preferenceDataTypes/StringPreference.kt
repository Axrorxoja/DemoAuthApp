package com.example.axrorxoja.demoauthapp.model.storage.preferenceDataTypes

import android.content.SharedPreferences
import com.example.axrorxoja.demoauthapp.extension.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
* Created by axrorxoja on 9/26/18
* String preference delegation
* for not implement get/set every field
* used [ReadWriteProperty]
*/
class StringPreference(
    private val pref: SharedPreferences,
    private val key: String,
    private val defValue: String = ""
) : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = pref.getString(key, defValue)
    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) = pref.edit { putString(key, value) }
}