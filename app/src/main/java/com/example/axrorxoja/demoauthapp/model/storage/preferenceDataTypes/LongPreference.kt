package com.example.axrorxoja.demoauthapp.model.storage.preferenceDataTypes

import android.content.SharedPreferences
import com.example.axrorxoja.demoauthapp.extension.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
* Created by axrorxoja on 9/26/18
* Long preference delegation
* for not implement get/set every field
* used [ReadWriteProperty]
*/
class LongPreference(
        private val pref: SharedPreferences,
        private val key: String,
        private val defValue: Long = 0L
) : ReadWriteProperty<Any, Long> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = pref.getLong(key, defValue)
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) = pref.edit { putLong(key, value) }
}