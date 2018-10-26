package com.example.axrorxoja.demoauthapp.entity.signUp

import com.example.axrorxoja.demoauthapp.entity.BaseRequest

class SignUpRequest(
    login: String = "",
    password: String = "",
    val firstName: String = "",
    val lastName: String = ""
) : BaseRequest(login, password)