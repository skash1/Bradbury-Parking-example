package com.example.service

import com.example.model.Cost
import com.example.model.parking.Parking
import com.example.model.transport.Transport
import java.time.Duration

fun interface ParkPlaceCostCalculationService {

    fun getParkingCost(parking: Parking, transport: Transport, duration: Duration): Cost

}
