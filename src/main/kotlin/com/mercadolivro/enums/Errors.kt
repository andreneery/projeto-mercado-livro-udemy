package com.mercadolivro.enums

enum class Errors(
    val code: String,
    val message: String
) {
    ML001(code = "ML-001", message = "Invalid request"),
    ML101(code = "ML-101", message = "Book [%s] not exists"),
    ML102(code = "ML-102", message = "Cannot update book with status [%s]"),
    ML201(code = "ML-201", message = "Customer [%s] not exists")

    /* o %s serve como um comando para pegar um valor que possui dentro de uma variavel, ou seja,
    quando colocado o format(id), ele irá pegar o valor que está dentro do id e passar para o %s */
}
