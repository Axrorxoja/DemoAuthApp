package com.example.axrorxoja.demoauthapp.entity

import com.example.axrorxoja.demoauthapp.common.ErrorObject


class BaseData<T>(
    val success: T? = null,
    val error: ErrorObject? = null
)