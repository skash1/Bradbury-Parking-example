package com.example.service.costcalc

import com.example.model.cost.Cost
import com.example.model.transport.Transport
import com.example.service.CostRateSelectService
import com.example.service.ParkPlaceCostCalculationService
import com.example.service.costcalc.strategy.CostCalculationFactory
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class TransportTypeParkPlaceCostCalculationService(
    private val costRateSelectorService: CostRateSelectService
) : ParkPlaceCostCalculationService {
    override fun getParkingCost(transport: Transport, duration: Duration): Cost {
        val costRate = costRateSelectorService.getCostRate(transport, duration)
            ?: throw IllegalStateException("""
                Unable to find cost rate for transport ${transport.transportType.name} 
                with millis duration ${duration.toMillis()}.""".trimIndent())
        return CostCalculationFactory.getStrategy(costRate).getCost(costRate, duration)
    }

}
