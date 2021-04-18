package com.mlacker.samples.eshop.domain

interface Repository<T : Entity> {

    fun find(id: Long): T?

    fun create(entity: T)

    fun update(entity: T)
}