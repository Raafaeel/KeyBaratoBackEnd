package br.upf.sistemacompradekeys.repository

import br.upf.sistemacompradekeys.model.Compra
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompraRepository: JpaRepository<Compra, Long> {

    fun findById(idCompra: Long, paginacao: Pageable): Page<Compra>
}