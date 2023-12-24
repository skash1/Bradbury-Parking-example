package com.example.dto.mapper

import com.example.dto.TransportDto
import com.example.model.transport.Transport

val transportDtoMapper = Mapper<Transport, TransportDto> {
    TransportDto(it.id, it.transportType, it.owner?.id, it.takenParkPlace?.id)
}
