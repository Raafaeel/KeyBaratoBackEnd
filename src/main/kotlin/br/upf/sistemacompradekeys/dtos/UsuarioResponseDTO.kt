package br.upf.sistemacompradekeys.dtos

data class UsuarioResponseDTO(
    val cpf: Long,
    val username: String,
    val regiao: String,
    val telefone: String,
    val email: String
)
