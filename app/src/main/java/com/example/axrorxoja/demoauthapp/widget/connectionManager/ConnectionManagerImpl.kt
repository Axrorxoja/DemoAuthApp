package com.example.axrorxoja.demoauthapp.widget.connectionManager

import android.net.ConnectivityManager

class ConnectionManagerImpl(private val manager: ConnectivityManager) : IConnectionManager {
    override fun isHaveNetwork(): Boolean = manager.activeNetworkInfo != null
}