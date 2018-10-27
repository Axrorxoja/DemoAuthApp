package com.example.axrorxoja.demoauthapp.ui.fragments

import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.view.View
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.extension.changeVisibility
import com.example.axrorxoja.demoauthapp.extension.showSnackbar
import com.example.axrorxoja.demoauthapp.extension.text
import com.example.axrorxoja.demoauthapp.presentation.IViewActivity
import com.example.axrorxoja.demoauthapp.presentation.signUp.IPresenterSignUp
import com.example.axrorxoja.demoauthapp.presentation.signUp.IViewSignUp
import com.example.axrorxoja.demoauthapp.ui.global.BaseDaggerFragment
import kotlinx.android.synthetic.main.fragment_sign_up.*
import javax.inject.Inject

class SignUpFragment : BaseDaggerFragment(),
    IViewSignUp {
    override val layoutRes: Int = R.layout.fragment_sign_up
    @Inject lateinit var presenter: IPresenterSignUp
    @Inject lateinit var activityView: IViewActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_save.setOnClickListener { onSaveUser() }
    }

    private fun onSaveUser() {
        btn_save.isEnabled = false
        presenter.signUp(
            ti_first_name.text(),
            ti_last_name.text(),
            ti_login.text(),
            ti_pass.text(),
            ti_pass_again.text()
        )
    }

    override fun onSuccess() = activityView.exit()

    override fun onFail(stringRes: Int) {
        onShowProgress(false)
        btn_save.isEnabled = true
        parent.showSnackbar(stringRes)
    }

    override fun onShowProgress(isShow: Boolean) = pb.changeVisibility(isShow)

    override fun lifeCycle(): LifecycleOwner = this
}
