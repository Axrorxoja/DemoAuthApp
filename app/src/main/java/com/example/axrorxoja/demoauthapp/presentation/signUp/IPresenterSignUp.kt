package com.example.axrorxoja.demoauthapp.presentation.signUp

interface IPresenterSignUp {
    fun signUp(
        firstName: String,
        lastName: String,
        login: String,
        password: String,
        passwordAgain: String
    )
}