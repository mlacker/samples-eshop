package com.mlacker.samples.eshop.repository

import com.mlacker.samples.eshop.domain.order.Order
import com.mlacker.samples.eshop.domain.order.OrderRepository
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class MemoryOrderRepository : OrderRepository {

    private val orders = ConcurrentHashMap<Long, Order>(5000)

    override fun find(id: Long): Order? {
        return orders[id]
    }

    override fun create(entity: Order) {
        orders[entity.id] = entity
    }

    override fun update(entity: Order) {
        create(entity)
    }
}