package br.upf.sistemaeventos.dtos

import br.upf.sistemaeventos.model.Compra
import br.upf.sistemaeventos.model.StatusDisp


data class JogoResponseDTO (
        val id: Long?,
        val chave: String,
        val regiao: String,
        val preco: Double,
        val descricao: String,
        val status: StatusDisp,
        val compras: List<Compra>
)