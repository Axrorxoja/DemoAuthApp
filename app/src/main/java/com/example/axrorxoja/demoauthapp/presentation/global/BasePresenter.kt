package com.example.axrorxoja.demoauthapp.presentation.global

import com.example.axrorxoja.demoauthapp.R
import com.example.axrorxoja.demoauthapp.common.ErrorCodes
import com.example.axrorxoja.demoauthapp.common.ErrorObject
import com.example.axrorxoja.demoauthapp.entity.BaseData

abstract class BasePresenter<T>(private val view: IViewBase) {

    private fun findAppropriateError(error: ErrorObject?): Int {
        return if (error != null) {
            when (error.code) {
                ErrorCodes.EMPTY_DATA -> R.string.data_is_empty
                ErrorCodes.PASSWORD_OR_LOGIN_INCORRECT -> R.string.pass_or_login_inc
                ErrorCodes.USER_NOT_FOUND -> R.string.user_not_found
                ErrorCodes.USER_WITH_SUCH_AUTH_CODE_NOT_FOUND -> R.string.user_with_such_auth_code_not_found
                ErrorCodes.VALIDATION_ERROR -> R.string.validation_error
                ErrorCodes.USER_WITH_SUCH_LOGIN_EXIST -> R.string.user_with_such_login_exist
                else -> R.string.un_known_error
            }
        } else {
            R.string.un_known_error
        }
    }

    open fun onSuccess(data: T) {
        view.onShowProgress(false)
        view.onSuccess()
    }

    protected fun checkData(data: BaseData<T>?) {
        if (data != null) {
            if (data.success != null) {
                onSuccess(data.success)
            } else {
                val resId = findAppropriateError(data.error)
                view.onFail(resId)
            }
        }
    }
}