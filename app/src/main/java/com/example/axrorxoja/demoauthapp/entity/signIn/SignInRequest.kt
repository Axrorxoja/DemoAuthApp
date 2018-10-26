package com.example.axrorxoja.demoauthapp.entity.signIn

import com.example.axrorxoja.demoauthapp.entity.global.BaseRequest

class SignInRequest(
    login: String = "",
    password: String = ""
) : BaseRequest(login, password)