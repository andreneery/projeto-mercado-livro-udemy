package com.mercadolivro.controller.response

import com.mercadolivro.enums.CustomerStatus

data class CustomerResponse (
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)

/* a classe Response serve para que não seja utilizada a modelagem do banco de dados, ou seja, impedir que as classes
consumam diretamente os dados que vem do banco de dados. Sendo o response um intermediário para a manipulação dos dados
 */
