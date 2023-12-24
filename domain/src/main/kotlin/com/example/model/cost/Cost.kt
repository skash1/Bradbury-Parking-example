package com.example.model.cost

import jakarta.persistence.Embeddable
import java.math.BigDecimal

@Embeddable
data class Cost(val amount: BigDecimal) {
    companion object {
        fun zero(): Cost = Cost(BigDecimal.ZERO)
    }
}
