package com.example.axrorxoja.demoauthapp.entity.signUp

import com.example.axrorxoja.demoauthapp.entity.BaseRequest

class SignUpRequest(
    val firstName: String = "",
    val lastName: String = "",
    login: String = "",
    password: String = ""
) : BaseRequest(login, password)