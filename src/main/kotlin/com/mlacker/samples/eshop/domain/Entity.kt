package com.mlacker.samples.eshop.domain

import java.util.concurrent.atomic.AtomicLong

abstract class Entity {

    open val id: Long = generateId()

    companion object {

        private val currentId = AtomicLong(1)

        fun generateId(): Long {
            return currentId.getAndIncrement()
        }
    }
}