package br.upf.sistemacompradekeys.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Usuario(
    @Id
        val cpf: Long,
    val email: String,
    @Enumerated(value = EnumType.STRING)
    val role: UserRole = UserRole.ADMIN,
    val regiao: String,
    val telefone: String,

    @OneToMany(mappedBy = "usuario")
    val compras: List<Compra> = listOf()
)


