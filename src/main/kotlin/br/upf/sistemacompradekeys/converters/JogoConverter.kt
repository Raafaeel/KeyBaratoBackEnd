package br.upf.sistemacompradekeys.converters

import br.upf.sistemacompradekeys.dtos.JogoDTO
import br.upf.sistemacompradekeys.dtos.JogoResponseDTO
import br.upf.sistemacompradekeys.model.Jogo
import org.springframework.stereotype.Component

@Component
class JogoConverter {
    fun toJogo(dto: JogoDTO): Jogo {
        return Jogo(
            descricao = dto.descricao,
            chave = dto.chave,
            regiao = dto.regiao,
            preco = dto.preco,
            status = dto.status,
            compras = listOf()
        )
    }

    fun toJogoResponseDTO(jogo: Jogo): JogoResponseDTO {
        return JogoResponseDTO(
            id = jogo.id,
            chave = jogo.chave,
            descricao = jogo.descricao,
            regiao = jogo.regiao,
            preco = jogo.preco,
            status = jogo.status,
            compras = jogo.compras
        )
    }
}