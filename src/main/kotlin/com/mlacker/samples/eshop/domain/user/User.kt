package com.mlacker.samples.eshop.domain.user

import com.mlacker.samples.eshop.domain.Entity

class User(
    override val id: Long,
    val name: String,
) : Entity() {
    var balance: Double = 0.0

    fun recharge(amount: Double) {
        balance += amount
    }

    fun payment(amount: Double) {
        balance -= amount
    }
}