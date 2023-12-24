package com.example.dto

import com.example.model.parking.ParkPlaceSize
import java.time.Instant

data class ParkPlaceDto(
    val id: Long,
    val capacityUsed: Int,
    val size: ParkPlaceSize,
    val takeMoment: Instant?,
    val transportUnits: List<TransportDto>,
//    val parking: ParkingDto
)
