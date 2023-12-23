package com.example.service

import com.example.model.cost.Cost
import com.example.model.transport.Transport
import java.time.Duration

fun interface ParkPlaceCostCalculationService {

    fun getParkingCost(transport: Transport, duration: Duration): Cost

}
