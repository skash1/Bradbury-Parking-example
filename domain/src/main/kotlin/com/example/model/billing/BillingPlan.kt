package com.example.model.billing

import com.example.model.billing.BillingPlan.Companion.BILLING_PLAN_TABLE_NAME
import com.example.model.parking.Parking
import jakarta.persistence.*

@Entity(name = BILLING_PLAN_TABLE_NAME)
class BillingPlan {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column
    var name: String = ""

    @OneToMany(fetch = FetchType.LAZY, mappedBy = BILLING_PERIOD_MAPPING, targetEntity = BillingPeriod::class)
    @OrderBy(BILLING_PERIOD_ORDER_BY)
    var periods: MutableList<BillingPeriod> = mutableListOf()

    @OneToOne(mappedBy = BILLING_PERIOD_MAPPING)
    @JoinColumn(name = PARKING_MAPPING_COLUMN_NAME, referencedColumnName = PARKING_MAPPING_REFERENCE_COLUMN_NAME)
    var parking: Parking? = null

    companion object {
        const val BILLING_PLAN_TABLE_NAME = "billing_plan"
        const val BILLING_PERIOD_MAPPING = "billingPlan"
        const val PARKING_MAPPING_COLUMN_NAME= "parking_id"
        const val PARKING_MAPPING_REFERENCE_COLUMN_NAME= "id"
        const val BILLING_PERIOD_ORDER_BY = "index asc"
    }

}
