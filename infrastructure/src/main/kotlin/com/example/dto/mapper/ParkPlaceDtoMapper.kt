package com.example.dto.mapper

import com.example.dto.ParkPlaceDto
import com.example.model.parking.ParkPlace

val parkPlaceMapper = Mapper<ParkPlace, ParkPlaceDto> {
    ParkPlaceDto(it.id, it.capacityUsed, it.size, it.takeMoment, it.transportUnits.map { transport -> transportDtoMapper.map(transport) })
}
