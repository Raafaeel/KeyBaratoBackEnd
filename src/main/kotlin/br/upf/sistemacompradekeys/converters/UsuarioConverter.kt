package br.upf.sistemacompradekeys.converters

import br.upf.sistemacompradekeys.dtos.UsuarioDTO
import br.upf.sistemacompradekeys.dtos.UsuarioResponseDTO
import br.upf.sistemacompradekeys.model.Usuario
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
            cpf = usuario.cpf,
            username = usuario.username,
            regiao = usuario.regiao,
            telefone = usuario.telefone,
            email = usuario.email
        )
    }

    fun toUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
            cpf = dto.cpf,
            //username = dto.username,
            regiao = dto.regiao,
            telefone = dto.telefone,
            email = dto.email,
            senha = BCryptPasswordEncoder().encode(dto.senha)
        )
    }
}
