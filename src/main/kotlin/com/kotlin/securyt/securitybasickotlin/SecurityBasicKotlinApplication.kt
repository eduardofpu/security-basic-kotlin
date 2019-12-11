package com.kotlin.securyt.securitybasickotlin

import com.kotlin.securyt.securitybasickotlin.model.Usuario
import com.kotlin.securyt.securitybasickotlin.repository.UsuarioRepository
import com.kotlin.securyt.securitybasickotlin.util.SenhaUtil
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecurityBasicKotlinApplication(val usuarioRepository: UsuarioRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        usuarioRepository.deleteAll()

        val password = SenhaUtil().gerarBcrypt("123456")
        val admin: Usuario = Usuario("admin", "admin@admin.com", password,true)
        usuarioRepository.save(admin)

        val user: Usuario = Usuario("user", "user@user.com", password,null)
        usuarioRepository.save(user)

        System.out.println("Nome: " + admin.username)
        System.out.println("Nome: " + user.username)

    }
}

/**
show databases
show tables
use jwt
db.usuario.find().pretty()
 **/
fun main(args: Array<String>) {
    runApplication<SecurityBasicKotlinApplication>(*args)
}