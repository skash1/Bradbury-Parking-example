package com.example.model.parking

import com.example.model.account.Account
import com.example.model.transport.Transport

data class ParkingPlaceRequest(
    val account: Account,
    val parking: Parking,
    val transport: Transport
)
