package com.mlacker.samples.eshop.domain.order

import com.mlacker.samples.eshop.domain.produce.Produce
import com.mlacker.samples.eshop.domain.user.User
import org.springframework.stereotype.Service

@Service
class OrderService {

    fun orders(user: User, produce: Produce): Order {
        val price = produce.currentMarketing?.let { produce.price * it.discount }
            ?: produce.price

        return Order(user.id, produce.id, price, produce.currentMarketing?.discount)
    }
}