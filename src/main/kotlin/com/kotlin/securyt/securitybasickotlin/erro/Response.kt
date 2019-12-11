package com.kotlin.securyt.securitybasickotlin.erro

data class Response<T> (
        val erros: ArrayList<String> = arrayListOf(),
        var data: T? = null
)