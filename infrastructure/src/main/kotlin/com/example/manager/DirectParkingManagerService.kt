package com.example.manager

import com.example.model.account.Account
import com.example.model.parking.ParkPlace
import com.example.model.parking.Parking
import com.example.model.transport.Transport
import com.example.repository.ParkPlaceRepository
import com.example.repository.TransportRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class DirectParkingManagerService @Autowired constructor(
    private val parkPlaceRepository: ParkPlaceRepository,
    private val transportRepository: TransportRepository
) : ParkingManagerService {
    override fun getAvailableParkPlaces(parking: Parking): List<ParkPlace> = parking.parkPlaces.filter { it.isFree() }

    override fun takeParkPlace(account: Account, parkPlace: ParkPlace, transport: Transport) {
        transport.apply { takenParkPlace = parkPlace }
            .also { transportRepository.save(it) }

        parkPlace.apply {
            capacityUsed = transport.transportType.requiredCapacity
            takeMoment = Instant.now()
        }.also { parkPlaceRepository.save(it) }
    }

    override fun releaseParkPlace(account: Account, parkPlace: ParkPlace, transport: Transport) {
        transport.apply { takenParkPlace = null }
            .also { transportRepository.save(it) }

        parkPlace.apply {
            capacityUsed = 0
            takeMoment = null
        }.also {
            parkPlaceRepository.save(it)
        }
    }
}
