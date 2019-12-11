package com.kotlin.securyt.securitybasickotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Usuario(
        val username: String,
        val email: String?,
        val password: String?,
        val admin: Boolean? = false,
        @Id val id: String? = null

)