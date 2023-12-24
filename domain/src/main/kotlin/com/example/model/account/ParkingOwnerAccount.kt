package com.example.model.account

import com.example.model.parking.Parking

class ParkingOwnerAccount : Account(AccountType.PARKING_OWNER) {

    private var parkingUnits: List<Parking> = listOf()

}
