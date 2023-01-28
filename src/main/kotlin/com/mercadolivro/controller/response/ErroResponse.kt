package com.mercadolivro.controller.response

data class ErroResponse (
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var errors: List<FieldErrorResponse>?
)
