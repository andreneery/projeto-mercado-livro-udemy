package com.mercadolivro.events.listeners

import com.mercadolivro.events.PurchaseEvents
import com.mercadolivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateNfeListener(
    private val purchaseService: PurchaseService
) {
    @Async
    @EventListener
    fun listen(purchaseEvents: PurchaseEvents){
        val nfe = UUID.randomUUID().toString()
        val purchaseModel = purchaseEvents.purchaseModel.copy(nfe = nfe)

        purchaseService.update(purchaseModel)
    }
}
