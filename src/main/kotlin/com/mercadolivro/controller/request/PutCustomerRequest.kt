package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest(
    @field: NotEmpty(message = "nome deve ser informado")
    val name: String,
    @field: Email(message = "email invalido")
    val email: String
)
