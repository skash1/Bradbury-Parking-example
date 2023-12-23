package com.example.service

import com.example.model.cost.CostRate
import com.example.model.transport.Transport
import java.time.Duration

fun interface CostRateSelectService {

    fun getCostRate(transport: Transport, duration: Duration): CostRate?

}
