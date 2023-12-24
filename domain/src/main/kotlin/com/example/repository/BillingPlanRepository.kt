package com.example.repository

import com.example.model.billing.BillingPlan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BillingPlanRepository: JpaRepository<BillingPlan, Long> {
}
