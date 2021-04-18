package com.mlacker.samples.eshop.controller

import com.mlacker.samples.eshop.controller.model.OrdersModel
import com.mlacker.samples.eshop.service.OrderAppService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    private val service: OrderAppService
) {

    @PostMapping
    fun orders(@RequestBody model: OrdersModel): Long =
        service.orders(model.userId, model.produceId)

    @PostMapping("/{id}/payment")
    fun payment(@PathVariable id: Long) =
        service.payment(id)

    @PostMapping("/{id}/cancel")
    fun cancel(@PathVariable id: Long) =
        service.cancel(id)
}