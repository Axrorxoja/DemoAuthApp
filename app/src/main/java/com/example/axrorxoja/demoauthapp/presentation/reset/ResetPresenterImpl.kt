package com.example.axrorxoja.demoauthapp.presentation.reset

import android.arch.lifecycle.Observer
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordRequest
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordResponse
import com.example.axrorxoja.demoauthapp.model.repository.reset.IResetRepository
import com.example.axrorxoja.demoauthapp.model.storage.IPreference
import com.example.axrorxoja.demoauthapp.presentation.global.BasePresenter
import com.example.axrorxoja.demoauthapp.widget.connectionManager.IConnectionManager

class ResetPresenterImpl(
    private val repo: IResetRepository,
    private val connection: IConnectionManager,
    private val view: IViewReset,
    private val pref: IPreference
) : BasePresenter<ResetPasswordResponse>(view),
    IPresenterReset {

    override fun reset(
        password: String,
        passwordAgain: String
    ) {
        if (password.isNotEmpty() &&
            passwordAgain.isNotEmpty()
        ) {
            if (password == passwordAgain) {
                if (connection.isHaveNetwork()) {
                    view.onShowProgress(true)
                    val req = ResetPasswordRequest(pref.code, password)
                    repo.reset(req).observe(view.lifeCycle(), Observer { checkData(it) })
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