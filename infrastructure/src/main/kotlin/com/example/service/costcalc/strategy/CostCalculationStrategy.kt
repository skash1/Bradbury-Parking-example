package com.example.service.costcalc.strategy

import com.example.model.cost.Cost
import com.example.model.cost.CostRate
import java.time.Duration

fun interface CostCalculationStrategy {

    fun getCost(costRate: CostRate, duration: Duration): Cost

}
