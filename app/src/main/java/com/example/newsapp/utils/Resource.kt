package com.example.newsapp.utils

import androidx.annotation.StringRes

sealed class Resource<T>(
    val data : T ?= null,
    val message :String ?= null
){

    class Success<T>(data : T , message: String?=null) : Resource<T>(data,message)
    class Error<T>(data : T ?= null , message: String?="" , @StringRes errorMessage : Int?) : Resource<T>(data,message)
}
