package br.upf.sistemacompradekeys.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()