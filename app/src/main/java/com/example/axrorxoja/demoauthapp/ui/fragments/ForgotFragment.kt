package com.example.axrorxoja.demoauthapp.ui.fragments


import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.view.View
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.extension.changeVisibility
import com.example.axrorxoja.demoauthapp.extension.hideKeyboard
import com.example.axrorxoja.demoauthapp.extension.showSnackbar
import com.example.axrorxoja.demoauthapp.extension.text
import com.example.axrorxoja.demoauthapp.presentation.IViewActivity
import com.example.axrorxoja.demoauthapp.presentation.forgot.IPresenterForgot
import com.example.axrorxoja.demoauthapp.presentation.forgot.IViewForgot
import com.example.axrorxoja.demoauthapp.ui.global.BaseDaggerFragment
import kotlinx.android.synthetic.main.fragment_forgot.*
import javax.inject.Inject

class ForgotFragment : BaseDaggerFragment(),
    IViewForgot {
    override val layoutRes: Int = R.layout.fragment_forgot
    @Inject lateinit var presenter: IPresenterForgot
    @Inject lateinit var activityView: IViewActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_forgot.setOnClickListener { onForgot() }
        ti_login.setOnEditorActionListener { _, actionId, _ -> onAction(actionId, this::onForgot) }
    }

    private fun onForgot() {
        btn_forgot.hideKeyboard()
        btn_forgot.isEnabled = false
        presenter.forgot(
            ti_first_name.text(),
            ti_last_name.text(),
            ti_login.text()
        )
    }

    override fun onSuccess() {
        activityView.onReset()
        btn_forgot.isEnabled = true
    }

    override fun onFail(stringRes: Int) {
        onShowProgress(false)
        btn_forgot.isEnabled = true
        parent.showSnackbar(stringRes)
    }

    override fun onShowProgress(isShow: Boolean) = pb.changeVisibility(isShow)

    override fun lifeCycle(): LifecycleOwner = this
}
