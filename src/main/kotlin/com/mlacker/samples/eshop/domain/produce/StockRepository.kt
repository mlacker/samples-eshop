package com.mlacker.samples.eshop.domain.produce

interface StockRepository {

    fun set(produce: Produce)

    fun acquire(produceId: Long): Boolean

    fun release(produceId: Long)
}