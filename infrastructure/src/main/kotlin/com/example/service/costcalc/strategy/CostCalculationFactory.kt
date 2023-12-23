package com.example.service.costcalc.strategy

import com.example.model.cost.CostRate

object CostCalculationFactory {

    fun getStrategy(costRate: CostRate): CostCalculationStrategy {
        return if (costRate.accountWholePeriod) {
            AccountWholePeriodCostCalculationStrategy()
        } else {
            PerUnitCostCalculationStrategy()
        }
    }

}
