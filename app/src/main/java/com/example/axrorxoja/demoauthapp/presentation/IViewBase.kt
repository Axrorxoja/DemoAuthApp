package com.example.axrorxoja.demoauthapp.presentation

import android.arch.lifecycle.LifecycleOwner
import android.support.annotation.StringRes

interface IViewBase {

    fun lifeCycle(): LifecycleOwner

    fun onSuccess()

    fun onFail(@StringRes stringRes: Int)

    fun onShowProgress(isShow: Boolean)

}