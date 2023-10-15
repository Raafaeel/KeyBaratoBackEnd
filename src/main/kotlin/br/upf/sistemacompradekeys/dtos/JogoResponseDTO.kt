package br.upf.sistemacompradekeys.dtos

import br.upf.sistemacompradekeys.model.Compra
import br.upf.sistemacompradekeys.model.StatusDisp


data class JogoResponseDTO (
        val id: Long?,
        val key: String,
        val regiao: String,
        val preco: Double,
        val descricao: String,
        val status: StatusDisp,
        val compras: List<Compra>
)