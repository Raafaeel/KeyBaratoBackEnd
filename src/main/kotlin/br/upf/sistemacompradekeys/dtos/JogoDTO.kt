package br.upf.sistemacompradekeys.dtos

import br.upf.sistemacompradekeys.model.Compra
import br.upf.sistemacompradekeys.model.StatusDisp
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class JogoDTO(
    @field:NotBlank(message = "Jogo sempre deve ter um nome")
    val descricao: String,
    val key: String,
    @field:NotNull(message = "Jogo sempre deve ter uma região")
    val regiao: String,
    @field:NotNull(message = "Jogo sempre deve ter preço")
    val preco: Double,
    val compras: List<Compra> = listOf(),
    val status: StatusDisp
)