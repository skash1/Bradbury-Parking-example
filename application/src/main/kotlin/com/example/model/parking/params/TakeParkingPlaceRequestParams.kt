package com.example.model.parking.params

import com.example.model.value.AccountId
import com.example.model.value.ParkingId
import com.example.model.value.TransportId

data class TakeParkingPlaceRequestParams(
    val accountId: AccountId,
    val parkingId: ParkingId,
    val transportId: TransportId
)
