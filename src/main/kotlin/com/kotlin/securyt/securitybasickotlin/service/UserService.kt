package com.kotlin.securyt.securitybasickotlin.service

import com.kotlin.securyt.securitybasickotlin.model.Usuario
import java.util.*

interface UsuarioService {
    fun create(usuario: Usuario): Usuario
    fun buscarPorId(id: String): Optional<Usuario>?
}