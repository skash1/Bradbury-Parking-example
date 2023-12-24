package com.example.strategy

import com.example.model.Cost
import com.example.model.transport.Transport
import kotlin.time.Duration

fun interface ParkPlaceCostCalculationStrategy {

    fun getParkingCost(transport: Transport, duration: Duration): Cost

}
