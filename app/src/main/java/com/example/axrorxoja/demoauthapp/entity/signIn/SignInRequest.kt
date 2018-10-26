package com.example.axrorxoja.demoauthapp.entity.signIn

import com.example.axrorxoja.demoauthapp.entity.BaseRequest

class SignInRequest(
    login: String = "",
    password: String = ""
) : BaseRequest(login, password)