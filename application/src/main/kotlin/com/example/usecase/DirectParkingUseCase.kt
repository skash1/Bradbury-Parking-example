package com.example.usecase

import arrow.core.Either
import com.example.exceptions.NotFoundException
import com.example.manager.ParkingManager
import com.example.model.parking.ParkingPlaceRequest
import com.example.model.parking.params.ReleaseParkingPlaceRequestParams
import com.example.model.parking.params.TakeParkingPlaceRequestParams
import com.example.model.value.AccountId
import com.example.model.value.ParkingId
import com.example.model.value.TransportId
import com.example.repository.AccountRepository
import com.example.repository.ParkingRepository
import com.example.repository.TransportRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class DirectParkingUseCase @Autowired constructor(
    private val parkingManager: ParkingManager,
    private val parkingRepository: ParkingRepository,
    private val accountRepository: AccountRepository,
    private val transportRepository: TransportRepository
) {

    @Transactional
    fun takeParkingPlace(requestParams: TakeParkingPlaceRequestParams): Either<Throwable, Unit> =
        Either.catch {
            val (account, parking, transport) = requestParams.run {
                getParkingPlaceRequest(accountId, parkingId, transportId)
            }
            parkingManager.getParkPlace(parking, transport)
                ?.let {
                    parkingManager.takeParkPlace(account, it, transport)
                }
                ?: throw NotFoundException("Unable to find available parking place.")
        }

    @Transactional
    fun releaseParkingPlace(requestParams: ReleaseParkingPlaceRequestParams): Either<Throwable, Unit> =
        Either.catch {
            val (account, parking, transport) = requestParams.run {
                getParkingPlaceRequest(accountId, parkingId, transportId)
            }
            val parkPlace = parking.parkPlaces.firstOrNull { parkPlace -> parkPlace.transportUnits.contains(transport) }
                ?: throw NotFoundException("Unable to find park place for transport ID ${transport.id}.")
            parkingManager.releaseParkPlace(account, parkPlace, transport)
        }

    private fun getParkingPlaceRequest(
        accountId: AccountId,
        parkingId: ParkingId,
        transportId: TransportId
    ): ParkingPlaceRequest {
        val account = accountRepository.findByIdOrNull(accountId.id)
            ?: throw NotFoundException("Unable to find account for ID ${accountId.id}.")
        val parking = parkingRepository.findByIdOrNull(parkingId.id)
            ?: throw NotFoundException("Unable to find paring for ID ${parkingId.id}.")
        val transport = transportRepository.findByIdOrNull(transportId.id)
            ?: throw NotFoundException("Unable to find transport for ID ${transportId.id}.")
        return ParkingPlaceRequest(account, parking, transport)
    }

}
