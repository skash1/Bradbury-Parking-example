package com.example.model.account

import com.example.model.parking.Parking
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany

@Entity
@DiscriminatorValue("PARKING_OWNER")
open class ParkingOwnerAccount : Account(AccountType.PARKING_OWNER) {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = PARKING_MAPPING, targetEntity = Parking::class)
    open var parkingUnits: MutableList<Parking> = mutableListOf()

    companion object {
        const val PARKING_MAPPING = "owner"
    }

}
