package br.upf.sistemacompradekeys.service

import br.upf.sistemacompradekeys.converters.UsuarioConverter
import br.upf.sistemacompradekeys.dtos.UsuarioDTO
import br.upf.sistemacompradekeys.dtos.UsuarioResponseDTO
import br.upf.sistemacompradekeys.exceptions.NotFoundException
import br.upf.sistemacompradekeys.repository.UsuarioRepository
import org.springframework.stereotype.Service

private const val USUARIO_NOT_FOUND_MESSAGE = "Usuário não encontrado!"

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val converter: UsuarioConverter
) {
    fun listar(): List<UsuarioResponseDTO> {
        return repository.findAll()
            .map(converter::toUsuarioResponseDTO)
    }

    fun buscarPorId(cpf: Int): UsuarioResponseDTO {
        val usuario = repository.findById(cpf)
            .orElseThrow { NotFoundException(USUARIO_NOT_FOUND_MESSAGE) }
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun cadastrar(dto: UsuarioDTO): UsuarioResponseDTO {
        return converter.toUsuarioResponseDTO(
            repository.save(converter.toUsuario(dto)))
    }

    fun atualizar(cpf: Int, dto: UsuarioDTO): UsuarioResponseDTO {
        val usuario = repository.findById(cpf)
            .orElseThrow { NotFoundException(USUARIO_NOT_FOUND_MESSAGE) }
            .copy(
                //username = dto.username,
                cpf = dto.cpf,
                telefone = dto.telefone
            )
        return converter.toUsuarioResponseDTO(repository.save(usuario))
    }

    fun deletar(cpf: Int) {
        repository.deleteById(cpf)
    }

}
