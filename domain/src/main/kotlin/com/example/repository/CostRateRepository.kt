package com.example.repository

import com.example.model.cost.CostRate
import com.example.model.transport.TransportType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.temporal.ChronoUnit

@Repository
interface CostRateRepository : JpaRepository<CostRate, Long> {

    fun findByTransportTypeAndUnitAndPeriodBoundMinBoundLessThanEqualOrderByPeriodBoundMinBound(
        transportType: TransportType,
        unit: ChronoUnit,
        lowestMaxBound: Int
    ) : List<CostRate>

}
