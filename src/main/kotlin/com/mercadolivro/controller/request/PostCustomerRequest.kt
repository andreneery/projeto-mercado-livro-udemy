package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field: NotEmpty
    val name: String,

    @field: Email
    val email: String
)
