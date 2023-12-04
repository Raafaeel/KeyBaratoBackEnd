package br.upf.sistemacompradekeys.controller

import br.upf.sistemacompradekeys.dtos.UsuarioDTO
import br.upf.sistemacompradekeys.dtos.UsuarioResponseDTO
import br.upf.sistemacompradekeys.service.UsuarioService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/usuario")
class UsuarioController(val service: UsuarioService) {

    @GetMapping
    fun listar(): List<UsuarioResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{cpf}")
    fun buscarPorId(@PathVariable cpf: Int): UsuarioResponseDTO {
        return service.buscarPorId(cpf)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: UsuarioDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<UsuarioResponseDTO> {
        val userResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/usuario/${userResponse.cpf}")
            .build().toUri()
        return ResponseEntity.created(uri).body(userResponse)
    }

    @PutMapping("/{cpf}")
    @Transactional
    fun atualizar(@PathVariable cpf: Int,
                  @RequestBody @Valid dto: UsuarioDTO
    ): UsuarioResponseDTO {
        return service.atualizar(cpf, dto)
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable cpf: Int) {
        service.deletar(cpf)
    }
}