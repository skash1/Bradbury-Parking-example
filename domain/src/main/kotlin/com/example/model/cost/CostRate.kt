package com.example.model.cost

import com.example.model.cost.CostRate.Companion.COST_RATE_TABLE_NAME
import com.example.model.parking.Parking
import com.example.model.transport.TransportType
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.time.temporal.ChronoUnit

@Entity(name = COST_RATE_TABLE_NAME)
class CostRate {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Enumerated(EnumType.STRING)
    @Column(name = TRANSPORT_TYPE_COLUMN_NAME)
    val transportType: TransportType? = null

    @Embedded
    @Column(name = UNIT_COST_COLUMN_NAME)
    val unitCost: Cost = Cost.zero()

    @Enumerated(EnumType.STRING)
    @Column
    val unit: ChronoUnit = ChronoUnit.MINUTES

    @Embedded
    val periodBound: PeriodBound = PeriodBound(0, 0)

    @Column(name = ACCOUNT_WHILE_PERIOD_COLUMN_NAME)
    val accountWholePeriod: Boolean = false

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = PARKING_MAPPING_COLUMN_NAME, nullable = false)
    val parking: Parking? = null

    companion object {
        const val COST_RATE_TABLE_NAME = "cost_rate"
        const val TRANSPORT_TYPE_COLUMN_NAME = "transport_type"
        const val UNIT_COST_COLUMN_NAME = "unit_cost"
        const val ACCOUNT_WHILE_PERIOD_COLUMN_NAME = "account_whole_period"
        const val PARKING_MAPPING_COLUMN_NAME = "parking_id"
    }

}


