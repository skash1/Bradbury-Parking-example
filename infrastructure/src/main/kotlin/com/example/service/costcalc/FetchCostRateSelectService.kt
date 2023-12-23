package com.example.service.costcalc

import com.example.model.cost.CostRate
import com.example.model.transport.Transport
import com.example.repository.CostRateRepository
import com.example.service.CostRateSelectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.temporal.ChronoUnit

@Component
class FetchCostRateSelectService @Autowired constructor(
    private val costRateRepository: CostRateRepository
) : CostRateSelectService {
    override fun getCostRate(transport: Transport, duration: Duration): CostRate? {
        val chronoUnit = duration.getMaxUnit()
        return costRateRepository.findByTransportTypeAndUnitAndPeriodBoundMinBoundLessThanEqualOrderByPeriodBoundMinBound(
                transport.transportType, chronoUnit, duration.inUnit(chronoUnit)
        ).firstOrNull()
    }

    private fun Duration.getMaxUnit(): ChronoUnit = when {
        toDays() > 0L -> ChronoUnit.DAYS
        toHours() > 0L -> ChronoUnit.HOURS
        toMinutes() > 0 -> ChronoUnit.MINUTES
        toSeconds() > 0 -> ChronoUnit.SECONDS
        else -> throw IllegalArgumentException("Can not represent duration to chrono unit")
    }

    private fun Duration.inUnit(unit: ChronoUnit): Int = when (unit) {
        ChronoUnit.DAYS -> toDays()
        ChronoUnit.HOURS -> toHours()
        ChronoUnit.MINUTES -> toMinutes()
        ChronoUnit.SECONDS -> toSeconds()
        else -> throw IllegalArgumentException("Can not represent duration to chrono unit")
    }.toInt()
}
