package com.example.service.select

import com.example.model.parking.ParkPlace
import com.example.model.parking.ParkPlaceSize
import com.example.model.parking.Parking
import com.example.model.transport.Transport
import com.example.repository.ParkPlaceRepository
import com.example.service.ParkPlaceSelectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class NextAvailableParkPlaceSelectService @Autowired constructor(
    private val parkPlaceRepository: ParkPlaceRepository
) : ParkPlaceSelectService {
    override fun getParkPlace(parking: Parking, transport: Transport): ParkPlace? {
        val suitableSizes = ParkPlaceSize.allWithSuitableCapacity(transport.transportType.requiredCapacity)
        return parkPlaceRepository.findAllBySizeIn(suitableSizes).firstOrNull { it.isFree()}
    }
}
