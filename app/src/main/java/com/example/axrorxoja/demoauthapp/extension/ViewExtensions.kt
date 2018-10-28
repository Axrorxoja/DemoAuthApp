package com.example.axrorxoja.demoauthapp.extension

import android.content.Context
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.view.View
import android.view.inputmethod.InputMethodManager

/*
* Created by axrorxoja on 9/27/18
*/

fun View.changeVisibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

fun View.showSnackbar(@StringRes textId: Int) = Snackbar.make(this, textId, Snackbar.LENGTH_SHORT).show()

fun TextInputEditText.text(): String = text.toString()

fun View.hideKeyboard(): Boolean {
    try {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    } catch (ignored: RuntimeException) {
    }
    return false
}