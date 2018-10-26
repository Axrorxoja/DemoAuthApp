package com.example.axrorxoja.demoauthapp.ui.fragments


import android.arch.lifecycle.LifecycleOwner
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.presentation.signUp.IViewSignUp
import com.example.axrorxoja.demoauthapp.ui.global.BaseFragment

class SignUpFragment : BaseFragment(),
    IViewSignUp {
    override val layoutRes: Int = R.layout.fragment_sign_up

    override fun onSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFail(stringRes: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onShowProgress(isShow: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun lifeCycle(): LifecycleOwner =this
}
