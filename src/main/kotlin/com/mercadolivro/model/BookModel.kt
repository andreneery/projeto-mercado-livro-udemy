package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
){
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value){
            if(field == BookStatus.DELETADO || field == BookStatus.CANCELADO){
                throw Exception("Livro não pode ser alterado. Status: ${field}")
            }
            field = value
        }
    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookStatus?
    ): this(id, name, price, customer){
        this.status = status
    }
    /* o constructor serve para manipular a data class, tendo em vista que passei o status para ser configurado no
    corpo da data class, eu preciso criar um constructor para manipular as informações e não quebrar o BookModel.
     */
}
