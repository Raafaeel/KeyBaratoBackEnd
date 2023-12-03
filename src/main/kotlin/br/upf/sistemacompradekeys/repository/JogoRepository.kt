package br.upf.sistemaeventos.repository

import br.upf.sistemaeventos.model.Compra
import br.upf.sistemaeventos.model.Jogo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JogoRepository: JpaRepository<Jogo, Long> {
   fun findByDescricao(descricaoJogo: String, paginacao: Pageable): Page<Jogo>
}