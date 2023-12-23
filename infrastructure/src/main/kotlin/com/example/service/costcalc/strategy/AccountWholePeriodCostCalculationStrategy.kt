package com.example.service.costcalc.strategy

import com.example.model.cost.Cost
import com.example.model.cost.CostRate
import java.time.Duration

class AccountWholePeriodCostCalculationStrategy : CostCalculationStrategy {
    override fun getCost(costRate: CostRate, duration: Duration): Cost {
        return Cost(costRate.unitCost.amount)
    }
}
