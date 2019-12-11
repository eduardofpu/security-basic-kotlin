package com.kotlin.securyt.securitybasickotlin.service.impl

import com.kotlin.securyt.securitybasickotlin.model.Usuario
import com.kotlin.securyt.securitybasickotlin.repository.UsuarioRepository
import com.kotlin.securyt.securitybasickotlin.service.UsuarioService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuariosServiceImpl(val usuarioRepository: UsuarioRepository) : UsuarioService {
    override fun buscarPorId(id: String): Optional<Usuario>? = usuarioRepository.findById(id)

    override fun create(usuario: Usuario): Usuario = usuarioRepository.save(usuario)
}