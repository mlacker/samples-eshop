package com.mlacker.samples.eshop.controller

import com.mlacker.samples.eshop.domain.produce.ProduceRepository
import com.mlacker.samples.eshop.domain.produce.StockRepository
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/produces")
class ProduceController(
    private val produceRepo: ProduceRepository,
    private val stockRepo: StockRepository
) {

    @PutMapping("/{id}/stock/reset")
    fun stockReset(@PathVariable id: Long) {
        val produce = produceRepo.find(id) ?: throw IllegalArgumentException()
        stockRepo.set(produce)
    }
}