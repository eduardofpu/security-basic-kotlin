package com.kotlin.securyt.securitybasickotlin.controller

import com.kotlin.securyt.securitybasickotlin.dto.UsuarioDto
import com.kotlin.securyt.securitybasickotlin.erro.Response
import com.kotlin.securyt.securitybasickotlin.model.Usuario
import com.kotlin.securyt.securitybasickotlin.service.UsuarioService
import com.kotlin.securyt.securitybasickotlin.util.SenhaUtil
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("v1")
class UsuarioController(val usuarioService: UsuarioService) {

    /**
     *  @PostMapping("/protected/auth/register")  para USER    verificar em SecurityConfig
     *  @PostMapping("/admin/auth/register")      PARA ADMIN   verificar em SecurityConfig
     *  @PreAuthorize("hasRole('USER')")          O MESMO QUE  @PostMapping("/protected/register")
     *  @PreAuthorize("hasRole('ADMIN')")         O MESMO QUE  @PostMapping("/admin/register")
     *  **/

    @PostMapping("/admin/register")
    fun create(@Valid @RequestBody usuarioDtos: UsuarioDto,
               result: BindingResult): ResponseEntity<Response<UsuarioDto>> {
        val response: Response<UsuarioDto> = Response<UsuarioDto>()
        validarUsuario(usuarioDtos, result)

        if (result.hasErrors()) {
            for (erro in result.allErrors) response.erros.add(erro.defaultMessage.toString())
            return ResponseEntity.badRequest().body(response)
        }

        val usuario: Usuario = converterDtoParaUsuario(usuarioDtos, result)
        usuarioService.create(usuario)
        response.data = converterUsuarioDtos(usuario)
        return ResponseEntity.ok(response)
    }

    private fun validarUsuario(usuarioDtos: UsuarioDto, result: BindingResult) {
        if (usuarioDtos.username == null) {
            result.addError(ObjectError("usuario",
                    "Usuário não informado."))
            return
        }
    }

    private fun converterUsuarioDtos(usuario: Usuario): UsuarioDto =
            UsuarioDto(usuario.username, usuario.email, "private", usuario.admin, "private")

    private fun converterDtoParaUsuario(usuarioDtos: UsuarioDto,
                                        result: BindingResult): Usuario {
        if (usuarioDtos.username == null) {
            result.addError(ObjectError("usuario",
                    "Usuário não encontrado."))
        }
        return Usuario(usuarioDtos.username, usuarioDtos.email, SenhaUtil().gerarBcrypt(usuarioDtos.password), usuarioDtos.admin, usuarioDtos.id)
    }
}