package com.mlacker.samples.eshop.repository

import com.mlacker.samples.eshop.domain.produce.Produce
import com.mlacker.samples.eshop.domain.produce.StockRepository
import org.springframework.stereotype.Repository
import java.util.concurrent.atomic.AtomicLong

@Repository
class MemoryStockRepository : StockRepository {

    private val stocks = mutableMapOf<Long, AtomicLong>()

    override fun set(produce: Produce) {
        stocks[produce.id] = AtomicLong(produce.stock)
    }

    override fun acquire(produceId: Long): Boolean {
        val stock = stocks[produceId] ?: throw IllegalArgumentException()

        synchronized(this) {
            if (stock.get() > 0) {
                stock.getAndDecrement()
                return true
            }
        }

        return false
    }

    override fun release(produceId: Long) {
        val stock = stocks[produceId] ?: throw IllegalArgumentException()
        stock.getAndIncrement()
    }
}