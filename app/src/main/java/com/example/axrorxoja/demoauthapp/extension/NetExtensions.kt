package com.example.axrorxoja.demoauthapp.extension

import android.net.ConnectivityManager
import com.example.axrorxoja.demoauthapp.common.NoResponseException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.experimental.suspendCoroutine


/*
* Created by axrorxoja on 10/26/18
*/

suspend fun <T> Call<T>.await(): T = suspendCoroutine { cont ->
    enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) = cont.resumeWithException(t!!)

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            if (response != null && response.isSuccessful) {
                cont.resume(response.body()!!)
            } else {
                cont.resumeWithException(
                    NoResponseException(response?.message() ?: "")
                )

            }
        }
    })
}

fun ConnectivityManager.isHaveNetwork() = activeNetworkInfo?.isConnected ?: false