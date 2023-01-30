package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostBookRequest(

    @field: NotEmpty(message = "nome deve ser informado")
    var name: String,

    @field: NotNull(message = "o valor deve ser informado")
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int

)
