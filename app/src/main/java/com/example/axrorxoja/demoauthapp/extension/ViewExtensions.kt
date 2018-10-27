package com.example.axrorxoja.demoauthapp.extension

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.view.View

/*
* Created by axrorxoja on 9/27/18
*/

fun View.changeVisibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

fun View.showSnackbar(@StringRes textId: Int) = Snackbar.make(this, textId, Snackbar.LENGTH_SHORT).show()

fun TextInputEditText.text(): String = text.toString()
