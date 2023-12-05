package br.upf.sistemacompradekeys.dtos

data class UsuarioDTO(
    val cpf: Long,
    val regiao: String,
    val telefone: String,
    val senha: String,
    val email: String
)
