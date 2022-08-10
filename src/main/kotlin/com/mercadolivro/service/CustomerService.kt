package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class CustomerService {

    //service serve para armazenar as regras de negócio

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
            // o let serve como um if se a variavel name for != de null
            // o contains serve para retornar em lista o nome que contem um do parametros,
            // sem necessidade de colocar o valor corretamente
            // já o ignoreCase é para retornar tanto maisculo ou minusculo
        }
        return customers
    }

    fun create(customer: CustomerModel) {

        val createId: Int = if(customers.isEmpty()){
            1
        }else {
            customers.last().id!! + 1
        }

        customer.id = createId

        customers.add(customer)


    }

    fun getId(id: Int): CustomerModel {
        return customers.filter { it.id == id}.first()
    }

    fun update(id: Int, customer: CustomerModel) {
        customers.filter { it.id == id}.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customers.removeIf{it.id == id}
    }
}