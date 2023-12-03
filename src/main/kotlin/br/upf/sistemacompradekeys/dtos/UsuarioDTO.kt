package br.upf.sistemaeventos.dtos

data class UsuarioDTO(
    val cpf: Long,
    val username: String,
    val regiao: String,
    val telefone: String,
    val senha: String,
    val email: String
)
