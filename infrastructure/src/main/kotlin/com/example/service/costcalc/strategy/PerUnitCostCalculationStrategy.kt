package com.example.service.costcalc.strategy

import com.example.model.cost.Cost
import com.example.model.cost.CostRate
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.Duration
import java.time.temporal.ChronoUnit

@Component
class PerUnitCostCalculationStrategy : CostCalculationStrategy {
    override fun getCost(costRate: CostRate, duration: Duration): Cost {
        val millis = duration.toMillis()
        val minDurationMillis = Duration.of(costRate.periodBound.minBound.toLong(), costRate.unit).toMillis()
        val usedDuration = Duration.of(millis - minDurationMillis, ChronoUnit.MILLIS)
        val timesUsed = usedDuration.dividedBy(Duration.of(1, costRate.unit))
        val timesDecimal = BigDecimal.valueOf(timesUsed).setScale(2)
        val amount = costRate.unitCost.amount.times(timesDecimal)
        return Cost(amount)
    }
}
