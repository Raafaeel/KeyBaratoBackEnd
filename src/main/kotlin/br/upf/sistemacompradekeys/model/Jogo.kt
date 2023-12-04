package br.upf.sistemacompradekeys.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Jogo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val chave: String,
    val regiao: String,
    val descricao: String,
    var preco: Double,
    @Enumerated(value = EnumType.STRING)
    val status: StatusDisp,
    @OneToMany(mappedBy = "jogo")
    val compras: List<Compra> = listOf()
)