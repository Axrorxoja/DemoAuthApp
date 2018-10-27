package com.example.axrorxoja.demoauthapp.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.v4.content.ContextCompat
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.axrorxoja.demoauthapp.R

/*
* Created by axrorxoja on 9/27/18
*/


fun ViewGroup.inflate(
    inflater: LayoutInflater,
    @LayoutRes layoutRes: Int
): View {
    return inflater.inflate(layoutRes, this, false)
}


fun View.hideKeyboard(): Boolean {
    try {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    } catch (ignored: RuntimeException) {
    }
    return false
}

/**
 * Extension method to showView a keyboard for View.
 */
fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, 0)
}

fun View.changeVisibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

fun View.hideView() {
    visibility = View.INVISIBLE
}

fun View.goneView() {
    visibility = View.GONE
}

fun View.showSnackbar(
    @StringRes textId: Int,
    timeOut: Int,
    listener: View.OnClickListener? = null,
    @StringRes linkTextId: Int = R.string.retry
) {
    val snackBar = Snackbar.make(this, textId, timeOut)
    listener?.let { snackBar.setAction(linkTextId, it) }
    hideKeyboard()
    snackBar.show()
}


fun Context.getColorCompat(color: Int) = ContextCompat.getColor(this, color)

fun Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) =
    this?.let { Toast.makeText(it, text, duration).show() }

fun Context?.toast(@StringRes textId: Int, duration: Int = Toast.LENGTH_LONG) =
    this?.let { Toast.makeText(it, textId, duration).show() }

fun View.hide() {
    this.animate()
        .alpha(0f)
        .setDuration(200)
        .setInterpolator(FastOutLinearInInterpolator())
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                visibility = View.INVISIBLE
            }
        })
}

fun View.show() {
    this.animate()
        .alpha(1f)
        .setDuration(200)
        .setInterpolator(LinearOutSlowInInterpolator())
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                visibility = View.VISIBLE
            }
        })
}

fun TextInputEditText.text(): String = text.toString()
