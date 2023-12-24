package com.example.repository

import com.example.model.billing.BillingPeriod
import com.example.model.billing.BillingPlan
import com.example.model.transport.TransportType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BillingPeriodRepository: JpaRepository<BillingPeriod, Long> {

    fun findByBillingPlanAndTransportType(billingPlan: BillingPlan, transportType: TransportType): List<BillingPeriod>

}
