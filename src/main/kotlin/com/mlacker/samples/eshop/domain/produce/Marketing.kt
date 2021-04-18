package com.mlacker.samples.eshop.domain.produce

import com.mlacker.samples.eshop.domain.Entity
import java.util.concurrent.atomic.AtomicLong

class Marketing(
    val name: String,
    val startTime: Long,
    val endTime: Long
) : Entity() {
    val createTime: Long = System.currentTimeMillis()

    private val count = AtomicLong()

    val discount: Double
        get() {
            val count = if (this.count.get() < 1000)
                this.count.getAndIncrement()
            else
                1000

            return when {
                count < 100 -> 0.1
                count < 500 -> 0.5
                count < 1000 -> 0.8
                else -> 1.0
            }
        }
}