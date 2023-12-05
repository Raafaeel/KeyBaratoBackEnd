package br.upf.sistemacompradekeys.repository

import br.upf.sistemacompradekeys.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Int> {

    fun findByEmail(email: String)

}
