package br.upf.sistemacompradekeys.service

import br.upf.sistemacompradekeys.dtos.JogoDTO
import br.upf.sistemacompradekeys.dtos.JogoResponseDTO
import br.upf.sistemacompradekeys.exceptions.NotFoundException
import br.upf.sistemacompradekeys.repository.JogoRepository
import br.upf.sistemacompradekeys.converters.JogoConverter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val JOGO_NOT_FOUND_MESSAGE = "Jogo não encontrado!"

@Service
class JogoService(
    private val repository: JogoRepository,
    private val converter: JogoConverter
) {

    fun listar(
            idJogo: Long?,
        paginacao: Pageable): Page<JogoResponseDTO> {
        val jogos = if (idJogo == null) {
            repository.findAll(paginacao)
        } else {
            repository.findById(idJogo , paginacao)
        }
        return jogos
            .map(converter::toJogoResponseDTO)
    }

    fun buscarPorId(id: Long): JogoResponseDTO {
        val jogo = repository.findById(id)
            .orElseThrow { NotFoundException(JOGO_NOT_FOUND_MESSAGE) }
        return converter.toJogoResponseDTO(jogo)
    }

    fun cadastrar(dto: JogoDTO): JogoResponseDTO {
        return converter.toJogoResponseDTO(
            repository.save(converter.toJogo(dto))
        )
    }

    fun atualizar(id: Long, dto: JogoDTO): JogoResponseDTO {
        val jogo = repository.findById(id)
            .orElseThrow { NotFoundException(JOGO_NOT_FOUND_MESSAGE) }
            .copy(
                regiao = dto.regiao,
                chave = dto.chave,
                preco = dto.preco,
                descricao = dto.descricao,
                status = dto.status
            )
        return converter.toJogoResponseDTO(repository.save(jogo))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}