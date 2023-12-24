package com.example.service

import com.example.model.parking.ParkPlace
import com.example.model.parking.Parking
import com.example.model.transport.Transport

fun interface ParkPlaceSelectService {

    fun getParkPlace(parking: Parking, transport: Transport): ParkPlace?

}
