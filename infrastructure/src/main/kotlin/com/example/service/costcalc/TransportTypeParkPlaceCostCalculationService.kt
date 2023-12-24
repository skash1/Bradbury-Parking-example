package com.example.service.costcalc

import com.example.model.Cost
import com.example.model.billing.BillingPeriod
import com.example.model.parking.Parking
import com.example.model.transport.Transport
import com.example.repository.BillingPeriodRepository
import com.example.service.ParkPlaceCostCalculationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.Duration
import java.time.temporal.ChronoUnit

@Component
class TransportTypeParkPlaceCostCalculationService @Autowired constructor(
    private val billingPeriodRepository: BillingPeriodRepository
) : ParkPlaceCostCalculationService {
    override fun getParkingCost(parking: Parking, transport: Transport, duration: Duration): Cost = getBillingAmount(
        duration,
        billingPeriodRepository.findByBillingPlanAndTransportType(parking.billingPlan!!, transport.transportType)
    ).let { Cost(it) }

    private fun getBillingAmount(duration: Duration, periods: List<BillingPeriod>): BigDecimal {
        var resultingAmount = BigDecimal.ZERO
        var remainingDuration = duration
        periods.forEach {
            if (remainingDuration.isNegative) {
                return resultingAmount
            }
            val periodDuration = Duration.of(it.unitNumber.toLong(), it.unit)
            val periodAmount = if (it.accountWholePeriod) {
                it.cost
            } else {
                val usedDuration = if (periodDuration > remainingDuration) remainingDuration else periodDuration
                it.cost.times(usedDuration.inUnit(it.unit).toBigDecimal())
            }
            resultingAmount = resultingAmount.add(periodAmount)
            remainingDuration = remainingDuration.minus(periodDuration)
        }
        return resultingAmount
    }

    private fun Duration.inUnit(unit: ChronoUnit): Int = when (unit) {
        ChronoUnit.DAYS -> toDays()
        ChronoUnit.HOURS -> toHours()
        ChronoUnit.MINUTES -> toMinutes()
        ChronoUnit.SECONDS -> toSeconds()
        else -> throw IllegalArgumentException("Can not represent duration to chrono unit")
    }.toInt()

}
