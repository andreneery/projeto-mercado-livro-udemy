package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field: NotEmpty(message = "nome deve ser informado")
    val name: String,

    @field: Email(message = "email deve ser valido")
    val email: String
)
