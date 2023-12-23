package com.example.manager

import com.example.model.account.Account
import com.example.model.parking.ParkPlace
import com.example.model.parking.Parking
import com.example.model.transport.Transport
import com.example.repository.ParkPlaceRepository
import com.example.repository.TransportRepository
import com.example.service.ParkPlaceCostCalculationService
import com.example.service.ParkPlaceSelectService
import com.example.service.PaymentCheckoutService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant

@Component
class DirectParkingManager @Autowired constructor(
    private val parkPlaceSelectService: ParkPlaceSelectService,
    private val parkPlaceCostCalculationService: ParkPlaceCostCalculationService,
    private val paymentCheckoutService: PaymentCheckoutService,
    private val parkPlaceRepository: ParkPlaceRepository,
    private val transportRepository: TransportRepository
) : ParkingManager {
    override fun getParkPlace(parking: Parking, transport: Transport): ParkPlace? =
        parkPlaceSelectService.getParkPlace(parking, transport)

    override fun takeParkPlace(account: Account, parkPlace: ParkPlace, transport: Transport) {
        transport.apply { takenParkPlace = parkPlace }
            .also { transportRepository.save(it) }

        parkPlace.apply {
            capacityUsed = transport.transportType.requiredCapacity
            takeMoment = Instant.now()
        }.also { parkPlaceRepository.save(it) }
    }

    override fun releaseParkPlace(account: Account, parkPlace: ParkPlace, transport: Transport) {
        val parkingCost = parkPlaceCostCalculationService.getParkingCost(
            transport,
            Duration.between(parkPlace.takeMoment, Instant.now())
        )
        paymentCheckoutService.pay(account, parkingCost)
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
