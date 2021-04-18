package com.mlacker.samples.eshop.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EntityTest {

    @Test
    fun `default generate id`() {
        val entity = object : Entity() {}

        assertEquals(1, entity.id)
        assertEquals(1, entity.id)
    }
}