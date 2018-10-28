package com.example.axrorxoja.demoauthapp.ui.global

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo

abstract class BaseFragment : Fragment() {
    val fragmentTag: String = this::class.java.name

    abstract val layoutRes: Int
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    protected fun onAction(actionId: Int, callback: () -> Unit): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            callback()
            return true
        }
        return false
    }
}
