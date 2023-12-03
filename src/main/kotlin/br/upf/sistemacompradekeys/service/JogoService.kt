package br.upf.sistemaeventos.service

import br.upf.sistemaeventos.dtos.JogoDTO
import br.upf.sistemaeventos.dtos.JogoResponseDTO
import br.upf.sistemaeventos.exceptions.NotFoundException
import br.upf.sistemaeventos.repository.JogoRepository
import br.upf.sistemajogos.converters.JogoConverter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val EVENTO_NOT_FOUND_MESSAGE = "Jogo não encontrado!"

@Service
class JogoService(
    private val repository: JogoRepository,
    private val converter: JogoConverter
) {

    fun listar(
        descriacaoJogo: String?,
        paginacao: Pageable): Page<JogoResponseDTO> {
        val jogos = if (descriacaoJogo == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByDescricao(descriacaoJogo, paginacao)
        }
        return jogos
            .map(converter::toJogoResponseDTO)
    }

    fun buscarPorId(id: Long): JogoResponseDTO {
        val jogo = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
        return converter.toJogoResponseDTO(jogo)
    }

    fun cadastrar(dto: JogoDTO): JogoResponseDTO {
        return converter.toJogoResponseDTO(
            repository.save(converter.toJogo(dto))
        )
    }

    fun atualizar(id: Long, dto: JogoDTO): JogoResponseDTO {
        val jogo = repository.findById(id)
            .orElseThrow { NotFoundException(EVENTO_NOT_FOUND_MESSAGE) }
            .copy(
                regiao = dto.regiao,
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