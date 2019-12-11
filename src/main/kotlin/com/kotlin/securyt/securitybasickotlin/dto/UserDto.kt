package com.kotlin.securyt.securitybasickotlin.dto

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class UsuarioDto(
        @get:NotEmpty(message = "Nome não pode ser vazio.")
        @get:Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
        val username: String = "",
        @get:NotEmpty(message = "Email não pode ser vazio.")
        @get:Length(min = 5, max = 200, message = "Email deve conter entre 5 e 200 caracteres.")
        @get:Email(message="Email inválido.")
        val email: String? = "",
        val password: String? = null,
        val admin: Boolean? = false,
        val id: String? = null
)