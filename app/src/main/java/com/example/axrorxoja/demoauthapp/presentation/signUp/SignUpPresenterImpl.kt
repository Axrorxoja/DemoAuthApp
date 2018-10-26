package com.example.axrorxoja.demoauthapp.presentation.signUp

import android.arch.lifecycle.Observer
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.entity.signUp.SignUpRequest
import com.example.axrorxoja.demoauthapp.entity.signUp.SignUpResponse
import com.example.axrorxoja.demoauthapp.model.repository.signUp.ISignUpRepository
import com.example.axrorxoja.demoauthapp.presentation.BasePresenter
import com.example.axrorxoja.demoauthapp.widget.connectionManager.IConnectionManager

class SignUpPresenterImpl(
    private val repo: ISignUpRepository,
    private val view: IViewSignUp,
    private val connection: IConnectionManager
) : BasePresenter<SignUpResponse>(view),
    IPresenterSignUp {

    override fun signUp(
        firstName: String,
        lastName: String,
        login: String,
        password: String,
        passwordAgain: String
    ) {
        if (firstName.isNotEmpty() &&
            lastName.isNotEmpty() &&
            login.isNotEmpty() &&
            password.isNotEmpty()
        ) {
            if (password == passwordAgain) {
                if (connection.isHaveNetwork()) {
                    view.onShowProgress(true)
                    val req = SignUpRequest(firstName, lastName, login, password)
                    repo.signUp(req).observe(view.lifeCycle(), Observer { checkData(it) })
                } else {
                    view.onFail(R.string.network_not_available)
                }
            } else {
                view.onFail(R.string.password_dont_match)
            }
        } else {
            view.onFail(R.string.fields_is_empty)
        }
    }
}