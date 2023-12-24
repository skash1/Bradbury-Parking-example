package com.example.dto

import com.example.model.transport.TransportType

data class TransportDto(
    val id: Long,
    val transportType: TransportType,
    val ownerId: Long?,
    val takenParkPlaceId: Long?
)
