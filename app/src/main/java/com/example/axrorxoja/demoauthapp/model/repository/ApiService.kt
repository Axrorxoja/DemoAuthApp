package com.example.axrorxoja.demoauthapp.model.repository

import com.example.axrorxoja.demoauthapp.entity.forgot.ForgotRequest
import com.example.axrorxoja.demoauthapp.entity.forgot.ForgotResponse
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordRequest
import com.example.axrorxoja.demoauthapp.entity.reset.ResetPasswordResponse
import com.example.axrorxoja.demoauthapp.entity.signIn.SignInRequest
import com.example.axrorxoja.demoauthapp.entity.signIn.SignInResponse
import com.example.axrorxoja.demoauthapp.entity.signUp.SignUpRequest
import com.example.axrorxoja.demoauthapp.entity.signUp.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


/*
* Created by axrorxoja on 10/26/18
*/
interface ApiService {

    @POST("sign_in")
    fun signIn(@Body user: SignInRequest): Call<SignInResponse>

    @POST("sign_up")
    fun signUp(@Body user: SignUpRequest): Call<SignUpResponse>

    @POST("forgot")
    fun forgot(@Body user: ForgotRequest): Call<ForgotResponse>

    @POST("reset")
    fun reset(@Body user: ResetPasswordRequest): Call<ResetPasswordResponse>


}