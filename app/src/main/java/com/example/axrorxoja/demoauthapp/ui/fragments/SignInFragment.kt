package com.example.axrorxoja.demoauthapp.ui.fragments


import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.view.View
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.extension.changeVisibility
import com.example.axrorxoja.demoauthapp.extension.showSnackbar
import com.example.axrorxoja.demoauthapp.extension.text
import com.example.axrorxoja.demoauthapp.presentation.IViewActivity
import com.example.axrorxoja.demoauthapp.presentation.signIn.IPresenterSignIn
import com.example.axrorxoja.demoauthapp.presentation.signIn.IViewSignIn
import com.example.axrorxoja.demoauthapp.ui.global.BaseDaggerFragment
import kotlinx.android.synthetic.main.fragment_sign_in.*
import javax.inject.Inject


class SignInFragment : BaseDaggerFragment(),
    IViewSignIn {

    override val layoutRes: Int = R.layout.fragment_sign_in
    @Inject lateinit var presenter: IPresenterSignIn
    @Inject lateinit var activityView: IViewActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_enter.setOnClickListener { onSignIn() }
        tv_sign_up.setOnClickListener { activityView.onSignUp() }
        tv_forgot.setOnClickListener { activityView.onForgot() }
    }

    private fun onSignIn() {
        btn_enter.isEnabled = false
        presenter.signIn(tie_login.text(), tie_password.text())
    }

    override fun onSuccess() {
        activityView.onMain()
        btn_enter.isEnabled = true
    }

    override fun onFail(stringRes: Int) {
        onShowProgress(false)
        btn_enter.isEnabled = true
        parent.showSnackbar(stringRes)
    }

    override fun onShowProgress(isShow: Boolean) = pb.changeVisibility(isShow)

    override fun lifeCycle(): LifecycleOwner = this
}
