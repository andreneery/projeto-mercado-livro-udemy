package com.mercadolivro.service

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.exception.NotFoundException
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow{
            NotFoundException(
                message = Errors.ML201.message.format(id),
                errorCode = Errors.ML201.code
            )
        }
    }

    fun update(customer: CustomerModel) {
       if(!customerRepository.existsById(customer.id!!)){
           throw Exception("id não existe")
       }
           customerRepository.save(customer)
    }

    fun delete(id: Int) {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }
}
