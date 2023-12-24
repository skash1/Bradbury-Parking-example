package com.example.usecase

import arrow.core.Either
import arrow.core.right
import com.example.exceptions.NotFoundException
import com.example.manager.ParkingManagerService
import com.example.model.parking.ParkPlace
import com.example.model.parking.params.ReleaseParkingPlaceRequestParams
import com.example.model.parking.params.TakeParkingPlaceRequestParams
import com.example.model.value.ParkingId
import com.example.service.ParkPlaceCostCalculationService
import com.example.service.ParkPlaceSelectService
import com.example.service.PaymentCheckoutService
import com.example.validations.ParkingPlaceRequestValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.Duration
import java.time.Instant

@Component
class DirectParkingUseCase @Autowired constructor(
    private val parkingManagerService: ParkingManagerService,
    private val parkingPlaceRequestValidator: ParkingPlaceRequestValidator,
    private val parkPlaceSelectService: ParkPlaceSelectService,
    private val parkPlaceCostCalculationService: ParkPlaceCostCalculationService,
    private val paymentCheckoutService: PaymentCheckoutService,
) {

    @Transactional
    fun getAvailableParkingPlaces(parkingId: ParkingId): Either<Throwable, List<ParkPlace>> = Either.catch {
        val parking = parkingPlaceRequestValidator.getParking(parkingId)
        return parkingManagerService.getAvailableParkPlaces(parking).right()
    }

    @Transactional
    fun takeParkingPlace(requestParams: TakeParkingPlaceRequestParams): Either<Throwable, Unit> =
        Either.catch {
            val (account, parking, transport) = requestParams.run {
                parkingPlaceRequestValidator.getParkingPlaceRequest(accountId, parkingId, transportId)
            }
            parkPlaceSelectService.getParkPlace(parking, transport)
                ?.let {
                    parkingManagerService.takeParkPlace(account, it, transport)
                }
                ?: throw NotFoundException("Unable to find available parking place.")
        }

    @Transactional
    fun releaseParkingPlace(requestParams: ReleaseParkingPlaceRequestParams): Either<Throwable, Unit> =
        Either.catch {
            val (account, parking, transport) = requestParams.run {
                parkingPlaceRequestValidator.getParkingPlaceRequest(accountId, parkingId, transportId)
            }
            val parkPlace = parking.parkPlaces.firstOrNull { parkPlace -> parkPlace.transportUnits.contains(transport) }
                ?: throw NotFoundException("Unable to find park place for transport ID ${transport.id}.")
            val parkingCost = parkPlaceCostCalculationService.getParkingCost(
                parking,
                transport,
                Duration.between(parkPlace.takeMoment, Instant.now())
            )
            paymentCheckoutService.pay(account, parking.owner!!, parkingCost)
            parkingManagerService.releaseParkPlace(account, parkPlace, transport)
        }
}
