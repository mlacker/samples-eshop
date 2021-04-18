package com.mlacker.samples.eshop.repository

import com.mlacker.samples.eshop.domain.produce.Marketing
import com.mlacker.samples.eshop.domain.produce.Produce
import com.mlacker.samples.eshop.domain.produce.ProduceRepository
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
class FakeProduceRepository : ProduceRepository {

    private val produce = Produce(
        "Fake produce with marketing", 100.0, Produce.DEFAULT_STOCK, mutableListOf(
            Marketing(
                "Fake marketing",
                Instant.now().plusSeconds(30).toEpochMilli(),
                Instant.now().plusSeconds(3600).toEpochMilli(),
            )
        )
    )

    override fun find(id: Long): Produce? {
        return produce
    }

    override fun create(entity: Produce) {
        TODO("Not yet implemented")
    }

    override fun update(entity: Produce) {
        // nothing to do
    }

    override fun createMarketing(marketing: Marketing) {
        TODO("Not yet implemented")
    }
}