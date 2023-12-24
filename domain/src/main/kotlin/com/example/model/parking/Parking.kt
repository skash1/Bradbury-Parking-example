package com.example.model.parking

import com.example.model.account.Account
import com.example.model.billing.BillingPlan
import com.example.model.parking.Parking.Companion.PARKING_TABLE_NAME
import com.fasterxml.jackson.annotation.JsonBackReference
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

    @JsonBackReference
    @OneToOne
    @JoinColumn(name= BILLING_PLAN_MAPPING_COLUMN_NAME, referencedColumnName = BILLING_PLAN_MAPPING_REFERENCE_COLUMN_NAME)
    var billingPlan: BillingPlan? = null

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = PARKING_OWNER_ACCOUNT_MAPPING_COLUMN_NAME, nullable = false)
    var owner: Account? = null

    companion object {
        const val PARKING_TABLE_NAME = "parking"
        const val PARK_PLACE_MAPPING = "parking"
        const val BILLING_PLAN_MAPPING_COLUMN_NAME = "billing_plan_id"
        const val BILLING_PLAN_MAPPING_REFERENCE_COLUMN_NAME = "id"
        const val PARKING_OWNER_ACCOUNT_MAPPING_COLUMN_NAME = "owner_id"
    }

}
