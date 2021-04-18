package com.mlacker.samples.eshop.domain.produce

import com.mlacker.samples.eshop.domain.Repository

interface ProduceRepository : Repository<Produce> {

    fun createMarketing(marketing: Marketing)
}