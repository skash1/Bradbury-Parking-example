package com.example.validations

import com.example.exceptions.NotFoundException
import com.example.model.account.Account
import com.example.model.parking.ParkingPlaceRequest
import com.example.model.value.AccountId
import com.example.model.value.ParkingId
import com.example.model.value.TransportId
import com.example.repository.AccountRepository
import com.example.repository.ParkingRepository
import com.example.repository.TransportRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ParkingPlaceRequestValidator @Autowired constructor(
    private val accountRepository: AccountRepository,
    private val parkingRepository: ParkingRepository,
    private val transportRepository: TransportRepository
) {

    fun getAccount(accountId: AccountId): Account = accountRepository.findByIdOrNull(accountId.id)
        ?: throw NotFoundException("Unable to find account for ID ${accountId.id}.")

    fun getParking(parkingId: ParkingId) = parkingRepository.findByIdOrNull(parkingId.id)
        ?: throw NotFoundException("Unable to find paring for ID ${parkingId.id}.")

    fun getTransport(transportId: TransportId) = transportRepository.findByIdOrNull(transportId.id)
        ?: throw NotFoundException("Unable to find transport for ID ${transportId.id}.")

    fun getParkingPlaceRequest(
        accountId: AccountId,
        parkingId: ParkingId,
        transportId: TransportId
    ): ParkingPlaceRequest {
        val account = getAccount(accountId)
        val parking = getParking(parkingId)
        val transport = getTransport(transportId)
        return ParkingPlaceRequest(account, parking, transport)
    }

}
