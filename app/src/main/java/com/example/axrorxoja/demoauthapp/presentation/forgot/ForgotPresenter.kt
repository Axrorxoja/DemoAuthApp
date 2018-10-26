package com.example.axrorxoja.demoauthapp.presentation.forgot

import android.arch.lifecycle.Observer
import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.entity.forgot.ForgotRequest
import com.example.axrorxoja.demoauthapp.entity.forgot.ForgotResponse
import com.example.axrorxoja.demoauthapp.model.repository.forgot.IForgotRepository
import com.example.axrorxoja.demoauthapp.model.storage.IPreference
import com.example.axrorxoja.demoauthapp.presentation.BasePresenter
import com.example.axrorxoja.demoauthapp.widget.connectionManager.IConnectionManager

class ForgotPresenter(
    private val repo: IForgotRepository,
    private val pref: IPreference,
    private val view: IViewForgot,
    private val connection: IConnectionManager
) : BasePresenter<ForgotResponse>(view), IPresenterForgot {

    override fun forgot(firstName: String, lastName: String, login: String) {
        if (firstName.isNotEmpty() &&
            lastName.isNotEmpty() &&
            login.isNotEmpty()
        ) {
            if (connection.isHaveNetwork()) {
                val req = ForgotRequest(firstName, lastName, login)
                repo.forgot(req).observe(view.lifeCycle(),
                    Observer { checkData(it) })
            } else {
                view.onFail(R.string.network_not_available)
            }
        } else {
            view.onFail(R.string.fields_is_empty)
        }
    }

    override fun onSuccess(data: ForgotResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}