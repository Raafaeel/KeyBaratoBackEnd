package br.upf.sistemacompradekeys.dtos

data class UsuarioResponseDTO(
    val cpf: Int,
    val username: String,
    val regiao: String,
    val telefone: String,
    val email: String
)
