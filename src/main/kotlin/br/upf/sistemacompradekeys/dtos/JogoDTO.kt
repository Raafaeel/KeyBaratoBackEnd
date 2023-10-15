package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Compra
import br.upf.sistemaeventos.model.StatusDisp
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

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