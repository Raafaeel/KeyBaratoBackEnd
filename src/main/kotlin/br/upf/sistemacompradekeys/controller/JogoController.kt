package br.upf.sistemacompradekeys.controller

import br.upf.sistemacompradekeys.dtos.JogoDTO
import br.upf.sistemacompradekeys.dtos.JogoResponseDTO
import br.upf.sistemacompradekeys.service.JogoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/Jogo")
class JogoController(val service: JogoService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) descricaoJogo: String?,
        @PageableDefault(size = 10) paginacao: Pageable)
    : Page<JogoResponseDTO> {
        return service.listar(descricaoJogo, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): JogoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: JogoDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<JogoResponseDTO> {
        val jogoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/Jogo/${jogoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(jogoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: JogoDTO
    ): JogoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}