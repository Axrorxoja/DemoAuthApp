package com.example.axrorxoja.demoauthapp.extension

import android.content.SharedPreferences
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

inline fun FragmentManager.transAction(
    body: FragmentTransaction.() -> Unit,
    isAddToBackStack: Boolean = true
) {
    val transaction = beginTransaction()
    transaction.body()
    if (isAddToBackStack) transaction.addToBackStack(null)
//    transaction.commitAllowingStateLoss()
    transaction.commit()
}

inline fun SharedPreferences.edit(preferApply: Boolean = false, f: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.f()
    if (preferApply) editor.apply() else editor.commit()
}

fun <T> lazyFast(operation: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { operation() }



