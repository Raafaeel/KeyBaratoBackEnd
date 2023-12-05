package br.upf.sistemacompradekeys.dtos

data class UsuarioResponseDTO(
    val cpf: Long,
    val regiao: String,
    val telefone: String,
    val email: String
)
