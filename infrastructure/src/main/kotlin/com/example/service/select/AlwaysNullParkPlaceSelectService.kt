package com.example.service.select

import com.example.model.parking.ParkPlace
import com.example.model.parking.Parking
import com.example.model.transport.Transport
import com.example.service.ParkPlaceSelectService

class AlwaysNullParkPlaceSelectService : ParkPlaceSelectService {
    override fun getParkPlace(parking: Parking, transport: Transport): ParkPlace? = null
}
