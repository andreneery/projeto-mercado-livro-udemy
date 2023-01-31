package com.mercadolivro.events

import com.mercadolivro.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvents(
    source: Any,
    val purchaseModel: PurchaseModel
): ApplicationEvent(source){

}
