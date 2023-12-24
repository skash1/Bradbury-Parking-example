package com.example.strategy

import com.example.model.parking.ParkPlace
import com.example.model.parking.Parking

fun interface ParkPlaceSelectStrategy {

    fun getParkPlace(parking: Parking): ParkPlace?

}
