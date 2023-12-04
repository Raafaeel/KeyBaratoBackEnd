package br.upf.sistemacompradekeys.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class Usuario(
    @Id
        val cpf: Long,
    //val username: String,
    val senha: String,
    val email: String,
    @Enumerated(value = EnumType.STRING)
    val role: UserRole = UserRole.USER,
    val regiao: String,
    val telefone: String,

    @OneToMany(mappedBy = "usuario")
    val compras: List<Compra> = listOf()
) : UserDetails {
    override fun getAuthorities(): MutableList<SimpleGrantedAuthority> =
        if (role == UserRole.VENDOR) mutableListOf(
            SimpleGrantedAuthority("ROLE_VENDOR"),
            SimpleGrantedAuthority("ROLE_USER")
        )
        else mutableListOf(SimpleGrantedAuthority("ROLE_USER"))

    override fun getPassword() = senha

    override fun getUsername() = email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}
