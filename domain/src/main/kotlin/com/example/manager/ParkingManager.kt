package com.example.manager

import com.example.model.Cost
import com.example.model.parking.ParkPlace
import com.example.model.parking.Parking
import com.example.model.transport.Transport
import kotlin.time.Duration

interface ParkingManager {

    fun getParkPlace(parking: Parking): ParkPlace?

    fun getParkingCost(transport: Transport, duration: Duration): Cost

}
