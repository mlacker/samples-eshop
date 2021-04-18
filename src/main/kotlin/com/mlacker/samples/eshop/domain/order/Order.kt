package com.mlacker.samples.eshop.domain.order

import com.mlacker.samples.eshop.domain.Entity

class Order(
    val user: Long,
    val produce: Long,
    val price: Double,
    val discount: Double?,
) : Entity() {

    var paymentAmount: Double? = null
    var paymentTime: Long? = null
    var state: OrderState = OrderState.Unpaid
    val createTime: Long = System.currentTimeMillis()

    fun payment() {
        if (state != OrderState.Unpaid) {
            throw IllegalStateException()
        }

        state = OrderState.Paid
        paymentAmount = price
        paymentTime = System.currentTimeMillis()
    }

    fun cancel() {
        if (state != OrderState.Unpaid) {
            throw IllegalStateException()
        }

        state = OrderState.Canceled
    }
}

