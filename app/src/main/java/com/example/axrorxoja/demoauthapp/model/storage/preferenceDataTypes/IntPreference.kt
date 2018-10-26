package com.example.axrorxoja.demoauthapp.model.storage.preferenceDataTypes

import android.content.SharedPreferences
import com.example.axrorxoja.demoauthapp.extension.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
* Created by axrorxoja on 9/26/18
* Int preference delegation
* for not implement get/set every field
* used [ReadWriteProperty]
*/
class IntPreference(
    private val pref: SharedPreferences,
    private val key: String,
    private val defValue: Int = -1
) : ReadWriteProperty<Any, Int> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = pref.getInt(key, defValue)
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) = pref.edit { putInt(key, value) }
}