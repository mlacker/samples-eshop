package com.mlacker.samples.eshop.service

import com.mlacker.samples.eshop.domain.order.OrderRepository
import com.mlacker.samples.eshop.domain.order.OrderService
import com.mlacker.samples.eshop.domain.produce.ProduceRepository
import com.mlacker.samples.eshop.domain.produce.StockRepository
import com.mlacker.samples.eshop.domain.user.UserRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderAppService(
    private val service: OrderService,
    private val userRepo: UserRepository,
    private val produceRepo: ProduceRepository,
    private val orderRepo: OrderRepository,
    private val stockRepo: StockRepository
) : InitializingBean {

    override fun afterPropertiesSet() {
        val produce = produceRepo.find(1)
        stockRepo.set(produce!!)
    }

    @Transactional
    fun orders(userId: Long, produceId: Long): Long {
        if (!acquireStock(produceId)) {
            throw IllegalStateException()
        }

        val user = userRepo.find(userId) ?: throw IllegalArgumentException()
        val produce = produceRepo.find(produceId) ?: throw IllegalArgumentException()

        val order = service.orders(user, produce)
        orderRepo.create(order)

        return order.id
    }

    @Transactional
    fun payment(orderId: Long) {
        val order = orderRepo.find(orderId) ?: throw IllegalArgumentException()
        val user = userRepo.find(order.user) ?: throw IllegalArgumentException()

        user.payment(order.price)
        order.payment()

        userRepo.update(user)
        orderRepo.update(order)
    }

    @Transactional
    fun cancel(orderId: Long) {
        val order = orderRepo.find(orderId) ?: throw IllegalArgumentException()

        stockRepo.release(order.produce)

        order.cancel()
        orderRepo.update(order)
    }

    private fun acquireStock(produceId: Long): Boolean {
        return stockRepo.acquire(produceId)
    }
}