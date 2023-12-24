package com.example.model.billing

import com.example.model.billing.BillingPeriod.Companion.BILLING_PERIOD_TABLE_NAME
import com.example.model.transport.TransportType
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.temporal.ChronoUnit

@Entity(name = BILLING_PERIOD_TABLE_NAME)
class BillingPeriod {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column
    var index: Int = 0

    @Enumerated(EnumType.STRING)
    @Column
    var unit: ChronoUnit = ChronoUnit.MINUTES

    @Column(name = UNIT_NUMBER_COLUMN_NAME)
    var unitNumber: Int = 0

    @Column(name = ACCOUNT_WHOLE_PERIOD_COLUMN_NAME)
    var accountWholePeriod: Boolean = false

    @Column
    var cost: BigDecimal = BigDecimal.ZERO

    @Enumerated(EnumType.STRING)
    @Column(name = TRANSPORT_TYPE_COLUMN_NAME)
    var transportType: TransportType? = null

    @ManyToOne
    @JoinColumn(name = BILLING_PLAN_MAPPING_COLUMN_NAME, nullable = false)
    var billingPlan: BillingPlan? = null

    companion object {
        const val BILLING_PERIOD_TABLE_NAME = "billing_period"
        const val BILLING_PLAN_MAPPING_COLUMN_NAME = "billing_plan_id"
        const val UNIT_NUMBER_COLUMN_NAME = "unit_number"
        const val ACCOUNT_WHOLE_PERIOD_COLUMN_NAME = "account_whole_period"
        const val TRANSPORT_TYPE_COLUMN_NAME = "transport_type"
    }

}
