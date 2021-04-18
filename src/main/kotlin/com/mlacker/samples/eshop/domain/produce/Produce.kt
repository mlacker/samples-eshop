package com.mlacker.samples.eshop.domain.produce

import com.mlacker.samples.eshop.domain.Entity

class Produce(
    val name: String,
    val price: Double,
    var stock: Long,
    private val marketingList: MutableList<Marketing>
) : Entity() {

    val currentMarketing: Marketing?
        get() {
            val currentTimeMillis = System.currentTimeMillis()
            return marketingList.findLast { currentTimeMillis >= it.startTime && currentTimeMillis <= it.endTime }
        }

    companion object {
        const val DEFAULT_STOCK = 160_000L
    }
}