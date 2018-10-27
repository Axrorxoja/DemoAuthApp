package com.example.axrorxoja.demoauthapp.presentation.signIn

import android.arch.lifecycle.Observer
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.entity.signIn.SignInRequest
import com.example.axrorxoja.demoauthapp.entity.signIn.SignInResponse
import com.example.axrorxoja.demoauthapp.model.repository.signIn.ISignInRepository
import com.example.axrorxoja.demoauthapp.presentation.global.BasePresenter
import com.example.axrorxoja.demoauthapp.widget.connectionManager.IConnectionManager

class SignInPresenterImpl(
    private val repo: ISignInRepository,
    private val view: IViewSignIn,
    private val connection: IConnectionManager
) : BasePresenter<SignInResponse>(view),
    IPresenterSignIn {

    override fun signIn(login: String, password: String) {
        if (login.isNotEmpty() && password.isNotEmpty()) {
            if (connection.isHaveNetwork()) {
                view.onShowProgress(true)
                val req = SignInRequest(login, password)
                repo.signIn(req).observe(view.lifeCycle(), Observer { checkData(it) })
            } else {
                view.onFail(R.string.network_not_available)
            }
        } else {
            view.onFail(R.string.fields_is_empty)
        }
    }
}