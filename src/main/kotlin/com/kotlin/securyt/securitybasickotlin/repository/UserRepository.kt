package com.kotlin.securyt.securitybasickotlin.repository

import com.kotlin.securyt.securitybasickotlin.model.Usuario
import org.springframework.data.mongodb.repository.MongoRepository


interface UsuarioRepository: MongoRepository<Usuario, String> {
    fun findByUsername(username: String?): Usuario
    fun findByEmail(email: String?): Usuario
}