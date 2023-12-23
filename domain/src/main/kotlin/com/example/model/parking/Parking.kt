package com.example.model.parking

import com.example.model.account.Account
import com.example.model.cost.CostRate
import com.example.model.parking.Parking.Companion.PARKING_TABLE_NAME
import jakarta.persistence.*

@Entity(name = PARKING_TABLE_NAME)
class Parking {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column
    var name: String = ""

    @OneToMany(fetch = FetchType.LAZY, mappedBy = PARK_PLACE_MAPPING, targetEntity = ParkPlace::class)
    var parkPlaces: MutableList<ParkPlace> = mutableListOf()

    @OneToMany(fetch = FetchType.LAZY, mappedBy = COST_RATE_MAPPING, targetEntity = CostRate::class)
    var costRates: MutableList<CostRate> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = PARKING_OWNER_ACCOUNT_MAPPING_COLUMN_NAME, nullable = false)
    var owner: Account? = null

    companion object {
        const val PARKING_TABLE_NAME = "parking"
        const val PARK_PLACE_MAPPING = "parking"
        const val COST_RATE_MAPPING = "parking"
        const val PARKING_OWNER_ACCOUNT_MAPPING_COLUMN_NAME = "owner_id"
    }

}
